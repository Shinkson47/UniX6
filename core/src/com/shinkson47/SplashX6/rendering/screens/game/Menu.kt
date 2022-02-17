package com.shinkson47.SplashX6.rendering.screens.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.ui.List
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.gdx.musicevents.tool.file.FileChooser
import com.shinkson47.SplashX6.game.GameData
import com.shinkson47.SplashX6.game.GameHypervisor
import com.shinkson47.SplashX6.game.GameHypervisor.Companion.ConnectGame
import com.shinkson47.SplashX6.game.GameHypervisor.Companion.EndGame
import com.shinkson47.SplashX6.game.cities.Production
import com.shinkson47.SplashX6.game.units.UnitClass
import com.shinkson47.SplashX6.network.NetworkClient
import com.shinkson47.SplashX6.network.Packet
import com.shinkson47.SplashX6.network.PacketType
import com.shinkson47.SplashX6.network.Server
import com.shinkson47.SplashX6.rendering.StageWindow
import com.shinkson47.SplashX6.rendering.windows.W_Options
import com.shinkson47.SplashX6.rendering.windows.TerrainGenerationEditor
import com.shinkson47.SplashX6.rendering.windows.game.Music
import com.shinkson47.SplashX6.rendering.windows.game.W_Settlements
import com.shinkson47.SplashX6.rendering.windows.game.Spotify
import com.shinkson47.SplashX6.rendering.windows.game.W_Help
import com.shinkson47.SplashX6.rendering.windows.game.units.W_UnitsList
import com.shinkson47.SplashX6.utility.Assets.SKIN
import com.shinkson47.SplashX6.utility.Debug.DebugWindow
import com.shinkson47.SplashX6.utility.Utility.*

/**
 * # The menu bar used in-game to access tools, windows and more.
 */
class Menu(val _parent : GameScreen) : Table(SKIN) {

    val chooser = FileChooser.createSaveDialog("Choose save location", SKIN, Gdx.files.external("/"))
    // TODO raise drop down to top
    companion object {
        /**
         * # The height of a menu bar and it's contents
         */
        const val HEIGHT = 80f


        /**
         * # The minimum width of all menu items.
         */
        const val ITEM_WIDTH = 80f

        val NOTHING = _NOTHING()
        class _NOTHING : Runnable { override fun run() {} }
    }

    /**
     * # A Window used to display sub items.
     */
    val subActionMenu = SubActionMenu()

    init {
        //TODO localisation
        //TODO Tooltips
        setPosition(0f, _parent.height - HEIGHT)    // Move to top of screen
        setSize(_parent.width, HEIGHT)                    // Fill width
        center()                                         // Display all contents in the middle.

        // Set color
        //setBackground(SKIN.getDrawable("widet10"))
        _parent.stage.addActor(subActionMenu)

        chooser.setResultListener { success, result ->
            if (success)
                GameHypervisor.save(Gdx.files.external(AssertEndsWith(result.path(), ".X6")).file())
            true
        }

        chooser.setFilter { file -> file.path.matches(Regex("(.*(?:X6))")) || (file.isDirectory && !file.name.startsWith(".")) }
        chooser.setOkButtonText("Save")
        chooser.isResizable = true


        // =========================================================
        //              Menu bar construction.
        // =========================================================

        addMenuItem(this, "generic.game.game", NOTHING,
                MenuSubItem("generic.any.options", WindowAction(W_Options(_parent))) ,
                MenuSubItem("generic.game.new")         { GameHypervisor.NewGame() } ,
                //MenuSubItem("generic.game.load")           { GameHypervisor.load() } ,
                MenuSubItem("generic.game.quickload")   { GameHypervisor.quickload() } ,
                MenuSubItem("generic.game.save")        { chooser.show(stage) } ,
                MenuSubItem("generic.game.quicksave")   { GameHypervisor.quicksave() } ,
                MenuSubItem("!Rejoin")   { if (NetworkClient.isConnected()) { EndGame(); ConnectGame(); } } ,
                MenuSubItem("generic.game.end")         { EndGame() }
        )

        addMenuItem(this, "!Help", WindowAction(W_Help()))

        addMenuItem(this, "!Debug", WindowAction(DebugWindow()),
                MenuSubItem("!Defog All") { GameData.world!!.removeFogOfWar() },
                MenuSubItem("!Hard reset server") { Server.shutdown(); Server.boot() },
                MenuSubItem("!Reload Help Text") { W_Help.reload() },
                MenuSubItem("!World Generation", WindowAction(TerrainGenerationEditor())),
                MenuSubItem("!Publish Game") { Server.boot() },
                MenuSubItem("!Connect Locally") { NetworkClient.connect() },
                MenuSubItem("!Notify Start") {Server.sendToAllClients(Packet(PacketType.Start, GameData))},
                MenuSubItem("!Show a message") { message("Everything is fine :)")},
                MenuSubItem("!Show an error") { warnDev("Everything is broken :(")},
            MenuSubItem("!Reload UI") { GameHypervisor.gameRenderer!!.let { it.stage.clear(); it.createUI() }  },

                MenuSubItem("!Add a production project") { GameData.player!!.cities[0].production.queue(Production.UnitProductionProject(UnitClass.chariot)) }
        )


        addMenuItem(this, "specific.windows.music.spotify", WindowAction(Spotify()),
                MenuSubItem("meta.pseudographic.playPause")         { com.shinkson47.SplashX6.audio.Spotify.play() } ,
                MenuSubItem("meta.pseudographic.next")              { com.shinkson47.SplashX6.audio.Spotify.next() },
                MenuSubItem("meta.pseudographic.previous")          { com.shinkson47.SplashX6.audio.Spotify.previous() },
                MenuSubItem("!Built-In", WindowAction(Music())),
                MenuSubItem("specific.windows.music.connect") { com.shinkson47.SplashX6.audio.Spotify.create() }
        )

        addMenuItem(
            this, "specific.menubar.warroom", { GameHypervisor.cm_toggle() },
            MenuSubItem("generic.game.settlements") { W_Settlements() },
            MenuSubItem("generic.game.units") { W_UnitsList() },
            MenuSubItem("specific.windows.units.view") { GameHypervisor.unit_view() },
            MenuSubItem("specific.windows.units.viewDestination") { GameHypervisor.unit_viewDestination() },
            MenuSubItem("specific.windows.units.setDestination") { GameHypervisor.unit_setDestination() },
            MenuSubItem("specific.windows.units.disband") { GameHypervisor.unit_disband() },
        )

        addMenuItem(this, "generic.game.endTurn", { GameHypervisor.turn_end() })
    }




    // ========================================================
    //#endregion            inner classes
    // ========================================================

    /**
     * # A menu item
     * On the the main menu bar, this shows as a single button.
     * This menu item may have multiple sub actions,
     * but it also performs an action by itself.
     */
    // TODO image instead, tooltip, sub actions
    class MenuItem(val parentMenu: Menu, key: String, val action: Runnable, vararg subActions: MenuSubItem) : TextButton(local(key), SKIN, if (subActions.isEmpty()) "MenuItem" else "MenuItemList") {
        val subActions = subActions as Array<MenuSubItem>

        init {
            addListener(MenuItemClickListener())
        }

        /**
         * # A click listener which defines the click behaviour of a menu item.
         * including the manipulation of the sub action menu.
         *
         * If the sub action menu is open, click is cancelled. It is assumed
         * the user is trying to close the menu.
         */
        inner class MenuItemClickListener() : ClickListener() {

            override fun touchDown(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                return if (super.touchDown(event, x, y, pointer, button)) { // If touched inside button,
                    if (subActions.isEmpty()) return true
                       with (parentMenu.subActionMenu) {
                            if (isVisible) {        // If already showing
                                hide()
                                cancel()
                            } else
                                show(subActions, this@MenuItem)    // Otherwise, show.
                       }
                            true
                        } else
                            false
            }

            /**
             * On release, hides the menu if the mouse is still over the menu button.
             *
             * If the user moved the mouse elsewhere before releasing, keep the menu open
             * so they can interact with it.
             */
            override fun touchUp(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int) {
                super.touchUp(event, x, y, pointer, button)

                if (isOver && action != NOTHING)
                    parentMenu.subActionMenu.hide()
            }

            /**
             * If the button is down-up clicked, perform the default action.
             */
            override fun clicked(event: InputEvent?, x: Float, y: Float) = action.run()
        }
    }

    /**
     * # A small [StageWindow] that displays menu sub actions.
     */
    inner class SubActionMenu() : StageWindow() {
        // TODO change list items to a subitem class.
        /**
         * # A list view used to hold and show the items.
         */
        val l = object : List<MenuSubItem>(SKIN) {
            override fun getMinHeight(): Float {
                return 23f * this.items.size
            }

            override fun getMaxWidth(): Float {
                return prefWidth
            }
        }

        init {
            add(l)
                    .left()
                    .bottom()
                    .expand()
                    .grow()
            isVisible = false
            setPosition(0f, this@Menu.y - this.height)
            l.addListener(LambdaClickListener { select() })
            unDock(this)
        }

        /**
         * # Sets the items that the window is showing.
         * Replaces anything already being displayed,
         * and resizes the window to fit the new content.
         */
        fun set(i : Array<MenuSubItem>) {
            l.items.clear()
            i.forEach { l.items.add(it) }
            invalidate()

            l.invalidate()
            width = l.minWidth

            pack()
        }

        /**
         * # [set]'s the items, and shows the window.
         */
        fun show(subActions: Array<MenuSubItem>, menuItem: MenuItem) {
            set(subActions)

            isVisible = true
            pack()

            isResizable = false
            setPosition(menuItem.x, this@Menu.y - this.height)
        }

        /**
         * # Hides the window.
         * I hoped this one would explain itself...
         */
        fun hide() {
            isVisible = false
        }

        /**
         * # Runs the selected item, then hides.
         * If no item is selected, has no effect.
         */
        fun select() {
            if (l.selected == null) return
            l.selected.action.run()
            hide()
        }
    }

    class MenuSubItem(val key : String, val action : Runnable) {
        override fun toString(): String = local(key)
    }

    /**
     * # An menu action that controls a game-window.
     * When activated, toggles window visibility.
     *
     * Adds window to stage on init.
     */
    inner class WindowAction(val window : StageWindow) : Runnable {
        init {
            window.isVisible = false
        }

        override fun run() {
            window.toggleShown()
            window.toFront()
        }
    }

    // ========================================================
    //#endregion            inner classes
    // ========================================================
    /**
     * # Adds an item to the menu.
     */
    fun addMenuItem(parentMenu: Menu, key: String, action: Runnable, vararg subActions: MenuSubItem) = addMenuItem(MenuItem(parentMenu,key,action, *subActions))
    fun addMenuItem(item : MenuItem) = add(item).height(HEIGHT).width(ITEM_WIDTH)

}