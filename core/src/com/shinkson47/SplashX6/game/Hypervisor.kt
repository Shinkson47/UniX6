/*░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
 ░ FOSS 2022. The Splash Project.                                                                                                                                                 ░
 ░ https://www.shinkson47.in/SplashX6                                                                                                                                             ░
 ░ Jordan T. Gray.                                                                                                                                                                ░
 ░                                                                                                                                                                                ░
 ░                                                                                                                                                                                ░
 ░                                                                                                                                                                                ░
 ░           _____                    _____                    _____            _____                    _____                    _____                                           ░
 ░          /\    \                  /\    \                  /\    \          /\    \                  /\    \                  /\    \                         ______           ░
 ░         /::\    \                /::\    \                /::\____\        /::\    \                /::\    \                /::\____\                       |::|   |          ░
 ░        /::::\    \              /::::\    \              /:::/    /       /::::\    \              /::::\    \              /:::/    /                       |::|   |          ░
 ░       /::::::\    \            /::::::\    \            /:::/    /       /::::::\    \            /::::::\    \            /:::/    /                        |::|   |          ░
 ░      /:::/\:::\    \          /:::/\:::\    \          /:::/    /       /:::/\:::\    \          /:::/\:::\    \          /:::/    /                         |::|   |          ░
 ░     /:::/__\:::\    \        /:::/__\:::\    \        /:::/    /       /:::/__\:::\    \        /:::/__\:::\    \        /:::/____/                          |::|   |          ░
 ░     \:::\   \:::\    \      /::::\   \:::\    \      /:::/    /       /::::\   \:::\    \       \:::\   \:::\    \      /::::\    \                          |::|   |          ░
 ░   ___\:::\   \:::\    \    /::::::\   \:::\    \    /:::/    /       /::::::\   \:::\    \    ___\:::\   \:::\    \    /::::::\    \   _____                 |::|   |          ░
 ░  /\   \:::\   \:::\    \  /:::/\:::\   \:::\____\  /:::/    /       /:::/\:::\   \:::\    \  /\   \:::\   \:::\    \  /:::/\:::\    \ /\    \          ______|::|___|___ ____  ░
 ░ /::\   \:::\   \:::\____\/:::/  \:::\   \:::|    |/:::/____/       /:::/  \:::\   \:::\____\/::\   \:::\   \:::\____\/:::/  \:::\    /::\____\        |:::::::::::::::::|    | ░
 ░ \:::\   \:::\   \::/    /\::/    \:::\  /:::|____|\:::\    \       \::/    \:::\  /:::/    /\:::\   \:::\   \::/    /\::/    \:::\  /:::/    /        |:::::::::::::::::|____| ░
 ░  \:::\   \:::\   \/____/  \/_____/\:::\/:::/    /  \:::\    \       \/____/ \:::\/:::/    /  \:::\   \:::\   \/____/  \/____/ \:::\/:::/    /          ~~~~~~|::|~~~|~~~       ░
 ░   \:::\   \:::\    \               \::::::/    /    \:::\    \               \::::::/    /    \:::\   \:::\    \               \::::::/    /                 |::|   |          ░
 ░    \:::\   \:::\____\               \::::/    /      \:::\    \               \::::/    /      \:::\   \:::\____\               \::::/    /                  |::|   |          ░
 ░     \:::\  /:::/    /                \::/____/        \:::\    \              /:::/    /        \:::\  /:::/    /               /:::/    /                   |::|   |          ░
 ░      \:::\/:::/    /                  ~~               \:::\    \            /:::/    /          \:::\/:::/    /               /:::/    /                    |::|   |          ░
 ░       \::::::/    /                                     \:::\    \          /:::/    /            \::::::/    /               /:::/    /                     |::|   |          ░
 ░        \::::/    /                                       \:::\____\        /:::/    /              \::::/    /               /:::/    /                      |::|   |          ░
 ░         \::/    /                                         \::/    /        \::/    /                \::/    /                \::/    /                       |::|___|          ░
 ░          \/____/                                           \/____/          \/____/                  \/____/                  \/____/                         ~~               ░
 ░                                                                                                                                                                                ░
 ░                                                                                                                                                                                ░
 ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░*/

package com.shinkson47.SplashX6.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.math.Vector3
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import com.shinkson47.SplashX6.Client.Companion.DEBUG_MODE
import com.shinkson47.SplashX6.Client.Companion.client
import com.shinkson47.SplashX6.audio.AudioController
import com.shinkson47.SplashX6.audio.Spotify
import com.shinkson47.SplashX6.game.cities.Settlement
import com.shinkson47.SplashX6.game.units.Unit
import com.shinkson47.SplashX6.game.units.UnitClass
import com.shinkson47.SplashX6.game.world.WorldTerrain
import com.shinkson47.SplashX6.game.world.WorldTerrain.*
import com.shinkson47.SplashX6.game.world.WorldTerrain.Companion.TILE_HALF_HEIGHT
import com.shinkson47.SplashX6.game.world.WorldTerrain.Companion.TILE_HALF_WIDTH
import com.shinkson47.SplashX6.game.world.WorldTerrain.Companion.cartesianToIso
import com.shinkson47.SplashX6.input.KeyBinder
import com.shinkson47.SplashX6.network.Packet
import com.shinkson47.SplashX6.network.PacketType
import com.shinkson47.SplashX6.network.Server
import com.shinkson47.SplashX6.rendering.screens.MainMenu
import com.shinkson47.SplashX6.rendering.screens.TextScreen
import com.shinkson47.SplashX6.rendering.screens.Warroom
import com.shinkson47.SplashX6.rendering.screens.WorldCreation
import com.shinkson47.SplashX6.rendering.screens.game.GameScreen
import com.shinkson47.SplashX6.rendering.ui.StageWindow
import com.shinkson47.SplashX6.utility.*
import com.shinkson47.SplashX6.utility.APICondition.Companion.MSG_TRIED_EXCEPT
import com.shinkson47.SplashX6.utility.APICondition.Companion.REQ_IN_GAME
import com.shinkson47.SplashX6.utility.APICondition.Companion.REQ_NOT_IN_GAME
import com.shinkson47.SplashX6.utility.APICondition.Companion.REQ_UNIT_SELECTED
import com.shinkson47.SplashX6.utility.APICondition.Companion.THROW
import com.shinkson47.SplashX6.utility.APICondition.Companion.WARN
import com.shinkson47.SplashX6.utility.APICondition.Companion.invalidCall
import com.shinkson47.SplashX6.utility.APICondition.Companion.validateCall
import com.shinkson47.SplashX6.utility.Assets.AUDIO_MUSIC_GAME_OVER
import com.shinkson47.SplashX6.utility.Assets.TEXTURE_ART
import com.shinkson47.SplashX6.utility.Utility.message
import com.shinkson47.SplashX6.utility.debug.Debug
import java.io.*
import java.lang.Thread.sleep

/**
 * # The main overseer and API for the game.
 *
 * Manages and handles all interactions with the current game from the client.
 *
 * @author [Jordan T. Gray](https://www.shinkson47.in) on 16/04/2021
 * @version 1
 * @since PRE-ALPHA 0.0.1
 */
object GameHypervisor {
    //========================================================================
    //#region fields
    //========================================================================

    /**
     * ## The screen being used to display the game
     */
    @JvmStatic
    var gameRenderer: GameScreen? = null
    private set

    @Deprecated("Debug use only.")
    fun newGameRenderer() {
        gameRenderer = GameScreen()
        client.fadeScreen(gameRenderer!!)
    }

    /**
     * # Are we in a game? i.e is a game currently loaded and playable?
     * If false, game api calls are not valid.
     */
    @JvmStatic
    var inGame: Boolean = false
    private set

    /**
     * # Runnables to be performed on [turnEnd].
     * Removed after being performed once.
     */
    private val TURN_ASYNC_TASKS: ArrayList<TurnHook> = ArrayList()

    /**
     * # Runnables to be performed on [turnEnd].
     * Kept until removed, activated every turn.
     */
    private val TURN_HOOKS: ArrayList<TurnHook> = ArrayList()


    //========================================================================
    //#endregion fields
    //#region construction
    //========================================================================

    fun ConnectGame() {
        client.fadeScreen(WorldCreation(isConnecting = true))
    }

    /**
     * # Initiates the creation of a new game
     *
     * But does not actually create it. This method switches to the world creation window,
     * which will callback when the user has configured the game and has rendered the loading screen.
     * The game will then be generated in [GameHypervisor#doNewGameCallback()], during which the programme will be
     * un-responsive and unable to render.
     */
    @JvmStatic
    fun NewGame() {
        if (inGame) EndGame()
        client.fadeScreen(WorldCreation())
    }

    /**
     * # Initiates the loading of a game
     */
    fun LoadGame() {
        if (inGame) EndGame()
        client.fadeScreen(WorldCreation(isLoading = true))
    }

    /**
     * # Actually creates a new game
     * This is the main game creation routine that is ran under the loading screen.
     *
     * called by the world creation screen after it has rendered the "creating world" message to the user.
     */
    @JvmStatic
    fun doNewGameCallback() {
        doGameLoadCallback()
    }

    fun doGameLoadCallback() {
        doNewGamePRE()
        inGame = true
        doNewGamePOST()
    }

    /**
     * # Game creation sub-routine
     * This is ran before we are considered to be in-game.
     * Contains calls which do not require a game to be loaded.
     */
    private fun doNewGamePRE() {
        // create game data. Must be before game screen is created.
        // Local player is also created here.
        GameData.new()

        // Create a new game screen stored locally. It will be shown to the user in the FINAL.
        // For now, loading screen is still being displayed. This is just so we can access the camera and whatnot.
        gameRenderer = GameScreen()

        GameEndConditionChecker.init()
    }

    /**
     * # Game creation sub-routine
     * Ran AFTER we are considered to be in-game.
     * Contains calls which require a game to be loaded.
     */
    private fun doNewGamePOST() {
        for (i in 1..GameData.pref_civCount)
            nation_new_random()

        unit_select(0)    // Select the first unit created at world gen. Should be a settler.
        unit_view()             // Focus the camera on that unit.
        camera_skipMovement()   // Skip the camera travelling from 0,0 to the unit.
        // without that, the game always starts with the camera flying across the map.

        Spotify.create(autoOnly = true) // Try to connect to the api at startup. Don't prompt.
    }

    /**
     * # Game creation sub-routine
     * Final touches applied after game has been created
     */
    fun doNewGameFINAL() {
        gameRenderer!!.createUI() // Populate the game screen with GUI. can't be done whilst gr is null.

        // TODO This couldn't be done before a world is created, but is only temporary.
        // STOPSHIP : 17/04/2021 this is dumb and shouldn't stay
        Debug.create()
        KeyBinder.createGameBinds()

        if (!DEBUG_MODE) Spotify.pause()      // If possible, stop spotify.

        AudioController.playPlaylist(Assets.DEFAULT_PLAYLIST)
        switchToGameScreen()

        if (Server.alive)
            Server.sendToAllClients(Packet(PacketType.Start, GameData))
    }

    fun switchToGameScreen() {
        gameRenderer?.apply { client.fadeScreen(this) }   // Show the game screen to the user.
    }


    //========================================================================
    //#endregion construction
    //#region saving API
    //========================================================================

    @JvmStatic
    fun quickload() {
        validateCall(REQ_IN_GAME, THROW("Can only quickload in game. This should not be possible."))
        TODO()
    }

    /**
     * We are not in game, and are loading one.
     *
     * Populates GameData from a serialized file, then loads the game ui.
     */
    @JvmStatic
    fun load(f: File) {
        validateCall(REQ_NOT_IN_GAME, THROW(MSG_TRIED_EXCEPT("load a game", "a game is already loaded")))
        load(ObjectInputStream(FileInputStream(f)).readObject() as _GameData)
    }

    /**
     * We are not in game, and are loading one.
     *
     * Populates GameDate from an existing instance, then loads the ui.
     */
    @JvmStatic
    fun load(gd: _GameData) {
        validateCall(REQ_NOT_IN_GAME, THROW(MSG_TRIED_EXCEPT("load a game", "a game is already loaded")))
        GameData = gd
        GameData.deserialize()
        doGameLoadCallback()

    }

    /**
     * We are already in-game, and are changing the game data.
     *
     * GameData is replaced and de-serialized.
     *
     * A new renderer is created to render the world.
     */
    @JvmStatic
    fun update(newData: _GameData) {
        if (!inGame) return
        GameData = newData
        GameData.deserialize()
        gameRenderer!!.newRenderer()
    }

    @JvmStatic
    fun quicksave() {
        if (
            invalidCall(REQ_IN_GAME, THROW(MSG_TRIED_EXCEPT("quicksave a game", "no game is loaded")))
        ) return
        TODO()
    }

    @JvmStatic
    fun save(f: File) {
        validateCall(REQ_IN_GAME, THROW(MSG_TRIED_EXCEPT("save a game", "no game is loaded")))
        ObjectOutputStream(FileOutputStream(f)).writeObject(GameData)
    }

    /**
     * # Spawns a [unit] with the sprite of [spriteName] on iso co-oord [x],[y]
     * Cannot be used in a UnitAction; Modifies GameData.units. See [turn_asyncTask].
     */
    @JvmStatic
    fun spawn(pos: Vector3, spriteName: UnitClass) =
        spawn(pos.x.toInt(), pos.y.toInt(), spriteName)

    //TODO these shouldn't be in this region.
    /**
     * # Spawns a [unit] with the sprite of [spriteName] on iso co-oord [x],[y]
     * Cannot be used in a UnitAction; Modifies GameData.units. See [turn_asyncTask].
     */
    @JvmStatic
    fun spawn(x: Int, y: Int, spriteName: UnitClass, nation: Nation = GameData.player!!): Unit {
        requireNotNull(GameData.world, { " Tried to spawn with no world. " })
        require(GameData.nations.contains(nation)) { " Tried to spawn a unit into a nation which does not exist in this game. " }
        return Unit(spriteName, x, y).apply { nation.addUnit(this) }
    }

    /**
     * Creates a new random ai controlled nation.
     *
     * @param civType Civ type
     * @param ai Ai
     * @return [Nation]
     */
    fun nation_new_random(): Nation = nation_new(Utility.random(NationType.values()), ai = true)

    fun nation_new(civType: NationType, ai: Boolean = false): Nation {
        requireNotNull(GameData.world, { " Tried to create a new civilisation with no world. " })
        val nation = Nation(civType, ai)
        GameData.nations.add(nation)
        GameData.world!!.randomPointOnLand().apply { spawn(x.toInt(), y.toInt(), UnitClass.settler, nation) }
        return nation
    }

    /**
     * Eradicates the existance of a nation.
     *
     * Breaks down the relationships involved with it, and removes it from
     * [GameData.nations]
     *
     * > This does not remove the host from [GameData.player], as it would cause too many null safety issues.
     *
     * @param nation Nation to delete.
     * @see Nation.dissolve
     */
    fun nation_dissolve(nation: Nation) {
        nation.dissolve()
        GameData.nations.remove(nation)
        System.gc()
    }

    //========================================================================
    //#endregion saving
    //#region units
    //========================================================================

    // TODO api predicate for requiring a unit is selected.


    @JvmStatic
    fun unit_select(index: Int, nation: Nation = GameData.player!!) = unit_select(nation.units.get(index))

    /**
     * # Selects a unit for focus of manipulation
     * Other unit calls will use this selected unit.
     */
    @JvmStatic
    fun unit_select(unit: Unit) {
        validateCall(REQ_IN_GAME, THROW(MSG_TRIED_EXCEPT("Select a unit", "no game is loaded")))

//            if (!GameData.player!!.units.contains(unit))
//                throw IllegalArgumentException("Tried to select a unit that does not exist in the game data!")

        GameData.selectedUnit = unit
        unit_view()
    }

    /**
     * # Sets the destination of the selected unit to the cursor
     * in tile space.
     */
    @JvmStatic
    fun unit_setDestination() {
        if (invalidCall(REQ_UNIT_SELECTED, WARN("Can't set a unit's destination if no unit selected!"))) return

        with(GameData.selectedUnit!!) {
            val dest: Vector3 = cm_selectedTile()
            setDestination(dest.x, dest.y)

            unit_selectAction("Travel to destination")
        }
    }

    /**
     * # Focusses the camera on the selected units destination.
     */
    @JvmStatic
    fun unit_viewDestination() {
        if (invalidCall(REQ_UNIT_SELECTED, WARN("Can't view a unit's destination if no unit selected!"))) return
        camera_moveToTile(GameData.selectedUnit!!.destination!!.x, GameData.selectedUnit!!.destination!!.y)
    }


    /**
     * # focuesses the camera on the selected unit
     */
    @JvmStatic
    fun unit_view() {
        if (invalidCall(REQ_UNIT_SELECTED, WARN("Can't view a unit if no unit selected!"))) return
        camera_focusOn(GameData.selectedUnit!!.x + TILE_HALF_WIDTH, GameData.selectedUnit!!.y + TILE_HALF_HEIGHT)
    }

    /**
     * # Destroys the selected unit
     * Giving the user some resources in return.
     */
    @JvmStatic
    fun unit_disband() {
        if (invalidCall(REQ_UNIT_SELECTED, WARN("Can't disband a unit if no unit selected!"))) return
        unit_disband(unit_selected()!!)
    }

    @JvmStatic
    fun unit_disband(unit: Unit) {
        if (GameData.selectedUnit == unit) GameData.selectedUnit = null
        unit.ownedBy()?.units?.removeValue(unit, true)
        unit.dispose()
    }

    /**
     * Determines what units are within a given range
     *
     * @param range Range
     */
    fun unit_proximity(unit: Unit = unit_selected()!!, range: Int = 1) {

    }

    @JvmStatic
    fun unit_selected(): Unit? = GameData.selectedUnit

    @JvmStatic
    fun unit_selectAction(displayName: String) {
        if (invalidCall(REQ_UNIT_SELECTED, WARN("Can't mutate a unit if no unit selected!"))) return
        with(GameData.selectedUnit!!) {
            onTurnAction = availableActions.find { it.displayName == displayName }
        }
        unit_updateUnitWindow()
    }

    @Deprecated("Windows now automatically update on turn end.")
    @JvmStatic
    fun unit_updateUnitWindow() {
        //(GameWindowManager.WINDOW_DOCK.items.find { it.title == "Units" } as W_UnitsList).run()
    }

    @JvmStatic
    fun unit_canEnter(x: Int, y: Int): Boolean = GameData.world!!.getTile(x, y)!!.isLand


    //========================================================================
    //#endregion units
    //#region game control
    //========================================================================


    /**
     * Ends this turn, performing actions on units and invoking opposing players to
     * take thier turn.
     *
     * > N.B. : UnitActions cannot modify some game data directly, since it will cause a concurrent modification exception.
     * Instead, post a runnable to []
     */
    @JvmStatic
    fun turn_end() {
        doEndTurn_Units()
        doEndTurn_Async()
    }

    /**
     * # Stores a task to be run at the end of the next [turn_end].
     * Also used as a work-around for not being able to modify some game data from within
     * actions run on [turn_end]
     */
    @JvmStatic
    fun turn_asyncTask(runnable: TurnHook) = TURN_ASYNC_TASKS.add(runnable)

    @JvmStatic
    @Deprecated("Runnables have been replaced by the [TurnHook] alias.")
    fun turn_asyncTask(runnable: Runnable) = turn_asyncTask(object : TurnHook {
        override fun onTurn() {
            runnable.run()
        }
    })

    /**
     * # Stores a runnable that will be invoked after every turn.
     */
    @JvmStatic
    fun turn_hook(runnable: TurnHook) = TURN_HOOKS.add(runnable)


    @JvmStatic
    @Deprecated("Runnables have been replaced by the [TurnHook] alias.")
    fun turn_hook(runnable: Runnable) = turn_hook(object : TurnHook {
        override fun onTurn() {
            runnable.run()
        }
    })

    /**
     * # Removes a [turn_hook]
     */
    @JvmStatic
    fun turn_unhook(runnable: TurnHook) = TURN_HOOKS.remove(runnable)

    @JvmStatic
    @Deprecated("Runnables have been replaced by the [TurnHook] alias.")
    fun turn_unhook(runnable: Runnable) = turn_unhook(runnable as TurnHook)


    /**
     * Invokes player's units to perform thier turn action.
     */
    private fun doEndTurn_Units() {
        // META : If you get a concurrent modification exception here, then
        // an onTurnAction has modified the GameData units list.
        GameData.player!!.units.forEach { it.doTurn() }
    }

    private fun doEndTurn_Async() {
        TURN_ASYNC_TASKS.forEach { impldoEndTurn_Async(it)  }
        TURN_ASYNC_TASKS.clear()
        TURN_HOOKS.forEach { impldoEndTurn_Async(it) }
    }

    private fun impldoEndTurn_Async(r: Runnable) {
        Gdx.app.postRunnable {
            try {
                r.run()
            } catch (e: Exception) {
                Utility.warnDev("A turn hook failed! \n${e.message}", e = e)
                //Utility.warnDev("$")
            }
        }
    }

    //========================================================================
    //#endregion game control
    //#region settlement
    //========================================================================


    /**
     * # Creates a size 0 settlement at [x],[y] in style matching the player's [civType]
     * Does so using data from provided unit. Assumes unit is a settler.
     * Unit is disbanded after.
     */
    fun settle(it: Unit) {
        it.ownedBy()!!.settle(it.isoVec.cpy())

        unit_disband(it)
    }

    /**
     * # Creates a size 0 settlement at [x],[y] with the provided style.
     */
    fun settle(pos: Vector3) {
        GameData.player!!.settle(pos)
    }


    //========================================================================
    //#endregion settlement
    //#region camera control
    //========================================================================


    /**
     * # Focusses the camera on the provided unit.
     */
    @JvmStatic
    fun camera_focusOn(city: Settlement) = camera_focusOn(city.cartesianPosition())

    /**
     * # Focusses the camera on the provided unit.
     */
    @JvmStatic
    fun camera_focusOn(unit: Unit) = camera_focusOn(unit.x, unit.y)

    /**
     * # Focusses the camera on a cartesian x, y
     */
    @JvmStatic
    fun camera_focusOn(pos: Vector3) = camera_focusOn(pos.x, pos.y)

    /**
     * # Focusses the camera on a cartesian x, y
     */
    @JvmStatic
    fun camera_focusOn(x: Float, y: Float) {
        if (cm_active)
            gameRenderer!!.managementScreen.desiredCameraPosition.desired.set(x, y, 0f)
        else
            gameRenderer!!.cam.goTo(x, y)
    }

    /**
     * # The cartesian location in the world that the camera is looking at.
     */
    @JvmStatic
    fun camera_focusingOn(): Vector3 {
        with(gameRenderer!!.cam) {
            val v: Vector3 = desiredPosition.get().cpy()
            v.y = lookingAtY().toFloat()
            return v
        }
    }

    /**
     * # Returns the isometric version of [camera_focusingOn]
     */
    @JvmStatic
    fun camera_focusingOnTile(): Vector3 {
        val v = camera_focusingOn()
        return cartesianToIso(v.x.toInt(), v.y.toInt())
    }


    @JvmStatic
    fun camera_moveToTile(x: Int, y: Int) {
        with(WorldTerrain.isoToCartesian(x, y)) {
            camera_focusOn(this.x, this.y)
        }
    }

    @JvmStatic
    fun camera_moveToTile(x: Float, y: Float) =
        GameHypervisor.camera_moveToTile(x.toInt(), y.toInt())

    /**
     * Sets the camera's position to it's destination, skipping the travel between the two.
     *
     * Does so by lerping with an alpha of 100%.
     */
    @JvmStatic
    fun camera_skipMovement() {
        gameRenderer!!.cam.desiredPosition.next(1f)
    }


    //========================================================================
    //#endregion camera control
    //#region input
    //========================================================================

    @JvmStatic
    fun mouse_focusOnTile(): Vector3 {
        with(gameRenderer!!.cam) {
/*              val mousex = (Gdx.input.x + desiredPosition.present.x) - Gdx.graphics.height
                val mousey = yFromAngle(desiredTilt.present, (Gdx.graphics.height - Gdx.input.y.toDouble()) + desiredPosition.present.y )
                Debug.dump("X: $mousex")
                Debug.dump("Y: $mousey")*/
            //cartesianToIso(unprojected.x.toInt(), unprojected.y.toInt())
            val unprojected = unproject(Vector3(Gdx.input.x.toFloat(), Gdx.input.y.toFloat(), 0f))
            Debug.dump("Result: $unprojected")
            return unprojected
        }
    }

    //========================================================================
    //#endregion input
    //#region Control Mode
    //========================================================================

    @JvmStatic
    var cm_active = false
        private set

    /**
     * # Enters unit control mode
     *
     * Returns true if caused a transition, else false.
     */
    @JvmStatic
    fun cm_enter(): Boolean {
        if (cm_active) return false
        //cm_showStateCaps(true)
        cm_active = true
        client.fadeScreen(gameRenderer!!.managementScreen)
        cm_cancelDestinationSelect()
        return true
    }

    /**
     * # Exits unit control mode
     */
    @JvmStatic
    fun cm_exit() {
        if (invalidCall(REQ_IN_GAME, THROW("cm not accessable whilst not in game."))) return

        //cm_showStateCaps(false)
        cm_active = false
        client.fadeScreen(gameRenderer!!)
    }

    /**
     * Toggles between [cm_exit] and [cm_enter]
     */
    @JvmStatic
    fun cm_toggle() {
        if (cm_active) cm_exit() else cm_enter()
        unit_view()
    }

    //private fun cm_showStateCaps(value : Boolean) = Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, value)

    /**
     * # Returns the tile under the mouse cursor in control mode.
     */
    @JvmStatic
    fun cm_selectedTile(): Vector3 {
        //validateCall(REQ_UNIT_CONTROL_MODE) { cm_enter(); }

        return if (client.currentScreen is Warroom) {
            // Get point on world that mouse is pointing to.
            val unprojected = gameRenderer!!.managementScreen.camera.unproject(Vector3(Gdx.input.x.toFloat(), Gdx.input.y.toFloat(), 0f))

            // Find what tile that is and return it.
            cartesianToIso(unprojected.x.toInt(), unprojected.y.toInt())
        } else
            camera_focusingOnTile()
    }

    /**
     * Flag representing wether or not the ucm is currently selecting a unit destination.
     */
    @JvmStatic
    var cm_isSelectingDestination = false
        private set

    /**
     * # Selects a destination for a unit in UCM.
     *
     *
     */
    @JvmStatic
    fun cm_destinationSelect() {
        if (invalidCall(REQ_UNIT_SELECTED, WARN("Can't move a unit if no unit is selected!"))) return

        if (cm_isSelectingDestination)
            unit_setDestination()

        cm_isSelectingDestination = !cm_isSelectingDestination
    }

    @JvmStatic
    fun cm_cancelDestinationSelect() {
        cm_isSelectingDestination = false; }

    //========================================================================
    //#endregion ControlMode
    //#region breakdown
    //========================================================================


    /**
     * # Unloads game, disposing object, clearing memory, and generally breaking down the hypervisor.
     * After calling, Hypervisor is not available until a new game is loaded.
     */
    @JvmStatic
    fun dispose() {
        Server.shutdown()
        StageWindow.unPostAll()
        gameRenderer?.dispose()
        gameRenderer = null
        GameData.clear()
        TURN_HOOKS.clear()
        TURN_ASYNC_TASKS.clear()

        // FIXME: 28/07/2021 Possible for this to not take effect if the user enters any other screen within a second of getting to the main menu.
        Utility.dispatchDaemonThread("KeyBindingDisposer") {
            while (client.screen !is MainMenu) {
                sleep(1000)
            }
            KeyBinder.destroyGameBinds()
        }
    }

    /**
     * # Ends game, disposes, returns to main menu.
     * Can't be called from a UnitAction. See [turn_asyncTask].
     */
    @JvmStatic
    fun EndGame() {
        cm_exit()
        dispose()
        if (!DEBUG_MODE) Spotify.pause()

        inGame = false
        client.fadeScreen(MainMenu())
    }

    /**
     * calls [EndGame] only if we're in a game, as indicated by
     * [inGame]
     */
    fun AssertEndGame() {
        if (inGame) EndGame()
    }


    //========================================================================
    //#endregion breakdown
    //#region misc
    //========================================================================

}

object GameEndConditionChecker : TurnHook {
    fun init() {
        GameHypervisor.turn_hook(this)
    }
    private val dissolveList = ArrayList<Nation>()

    override fun onTurn() {

        GameData.nations.forEach { nation ->
            checkGameOver(nation)?.let {
                dissolveList.add(nation)
                message("The nation of ${GameData.player!!.nationType} has fallen!", isCrutial = true, persistant = true)

                if (nation == GameData.player!!)
                    onLocalGameOver(it)
            }
        }

        dissolveList.forEach {
            GameHypervisor.nation_dissolve(it)
        }
        dissolveList.clear()
    }

    /**
     * Notifies the local player that they have lost.
     */
    private fun onLocalGameOver(it: Pair<String, Boolean>) {
        client.fadeScreen(
            TextScreen(
                text = "Game Over! \n\n The nation of ${GameData.player!!.nationType} has fallen. \n(${it.first}) \n\n Press ESC to observe others or end the game.",
                background = TextureRegionDrawable(Assets.get<TextureAtlas>(TEXTURE_ART).findRegion(if (it.second) "img3" else "img6")),
                onESC = GameHypervisor.gameRenderer!!
            )
        )

        AudioController.play(Assets.get<Music>(AUDIO_MUSIC_GAME_OVER))
    }

    /**
     * Checks to see if any conditions have been met to end the game
     *
     * @return Null if no game over conditions are met. A message as to why the game ended, and a boolean representing win or loss. (true = win)
     */
    private fun checkGameOver(it: Nation): Pair<String, Boolean>? {
        with(it) {
            if (units.isEmpty && settlements.isEmpty)
                return Pair("No units or settlements remain", false)

        }

        return null
    }
}