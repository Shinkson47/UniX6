package com.shinkson47.SplashX6.rendering.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.Window
import com.gdx.musicevents.tool.file.FileChooser
import com.shinkson47.SplashX6.Client
import com.shinkson47.SplashX6.ai.StateMachine
import com.shinkson47.SplashX6.game.GameData
import com.shinkson47.SplashX6.game.GameHypervisor
import com.shinkson47.SplashX6.game.GameHypervisor.Companion.doNewGameCallback
import com.shinkson47.SplashX6.game.GameHypervisor.Companion.load
import com.shinkson47.SplashX6.game.cities.CityType
import com.shinkson47.SplashX6.network.NetworkClient.connect
import com.shinkson47.SplashX6.network.NetworkClient.isConnected
import com.shinkson47.SplashX6.network.Server
import com.shinkson47.SplashX6.network.Server.alive
import com.shinkson47.SplashX6.network.Server.boot
import com.shinkson47.SplashX6.rendering.ScalingScreenAdapter
import com.shinkson47.SplashX6.rendering.StageWindow
import com.shinkson47.SplashX6.rendering.windows.TerrainGenerationEditor
import com.shinkson47.SplashX6.utility.Assets
import com.shinkson47.SplashX6.utility.Assets.SKIN
import com.shinkson47.SplashX6.utility.UtilityK.getIP


/**
 * # Provides the user a place to configure the game and world generation
 *
 *
 *
 * @author [Jordan T. Gray on 16/04/2021](https://www.shinkson47.in)
 * @version 2
 * @since v1
 */
class WorldCreation(
    val isConnecting: Boolean = false,
    val isLoading: Boolean = false
) : ScalingScreenAdapter() {

    //==========================================
    //#region actors
    //==========================================

    /**
     * # A label that will display game tips whilst loading
     */
    private val tipLabel = Label("", SKIN)

    /**
     * # Table containing content displayed whilst loading
     */
    private val loadingContainer = Table()

    /**
     * # Window containing game configuration controls.
     */
    private val gameCreationWindow = W_GameCreation()

    private val chooser = FileChooser.createPickDialog("Choose save file", SKIN, Gdx.files.external("/"))

    init {
        chooser.setResultListener { success, result ->
            if (success && result != null) {
                stage.actors.removeValue(chooser, true)
                controller.switchState(2)
                true
            } else {
                GameHypervisor.EndGame()
                false
            }

        }
        chooser.setOkButtonText("Load")
        chooser.setFilter { file ->
            file.path.matches(Regex("(.*(?:X6))")) || (file.isDirectory && !file.name.startsWith(
                "."
            ))
        }
        chooser.isResizable = true
    }

    //==========================================
    //#endregion actors
    //==========================================

    private val controller = WorldCreationScreenController()

    //==========================================
    //#region operations
    //==========================================

    /**
     * # Renders the screen
     */
    override fun render(delta: Float) {
        controller.run()
        with(stage) {
            batch.begin()
            SKIN.getDrawable("tiledtex").draw(batch, 0f, 0f, width, height)
            batch.end()

            act()
            draw()
        }

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
            cancel()
    }

    /**
     * # Displays another random tip from [Assets.TIPS] in [tipLabel].
     */
    private fun nextTip() = tipLabel.setText(Assets.TIPS[MathUtils.random(Assets.TIPS.size - 1)])

    fun constructGeneratingText() = constructText("specific.gamecreation.generating")
    fun constructDeserializingText() = constructText("!Loading existing world. Please wait.")
    fun constructConnectingText() = constructText("!Waiting for host to start game.")
    private fun constructText(key: String) {
        with(loadingContainer) {
            setFillParent(true)

            StageWindow
                .label(key, this)
                .padBottom(50f)
                .row()

            nextTip()

            add(tipLabel)
                .row()
        }

        with(stage) {
            actors.clear()
            addActor(loadingContainer)
        }
    }


    /**
     * # Cancels the world generation, and returns to the main menu
     */
    fun cancel() {
        Server.shutdown()
        Client.client!!.fadeScreen(MainMenu())
    }

    //==========================================
    //#endregion operations
    //==========================================


    fun addw(w: Window) {
        stage.addActor(w)

        if (w is StageWindow)
            w.centerStage()
    }

    inner class W_GameCreation : StageWindow() {
        init {
            isResizable = false
            isMovable = false


            // TODO Civ class
            //      Opponents
            //      Preset world types
            //      World size
            //      Advanced terrain
            addButton("specific.gamecreation.terrainSettings", true, true) { stage.addActor(TerrainGenerationEditor()) }

            row()
            label("specific.gamecreation.civtype")

            val x = SelectBox<CityType>(SKIN)
            x.setItems(*CityType.values())
            x.selected = x.items.first()
            add(x)

            x.addListener(LambdaChangeListener { GameData.pref_civType = x.selected })

            span(
                hsep()
                    .padTop(30f)
            )

            span(addButton("generic.game.new") {
                controller.switchState(1)
            })
            row()
            span(addButton("!LAN") {
                controller.switchState(3)
//                else TODO
//                    dialog("!Not available!", "!Failed to start the server. Is there already one running?")
            })
            row()
            span(addButton("generic.buttons.cancel", false) { cancel() })
            updateColSpans()
            pack()
        }
    }

    private inner class W_NetworkConnect : StageWindow() {
        init {
            label("!HOST IP : ${getIP().hostAddress}")
            row()
            label("!Wait for players, then click start.")
            row()
            addButton("!Start Game!") { GameHypervisor.doNewGameFINAL() }

            pack()
        }
    }


    /**
     * # World Creation Screen State Machine.
     *
     * Controlls the state of the game loading window.
     *
     * Generated using Shinkson's State Machine Scripture.
     *
     * See WorldCreation.sms
     */
    inner class WorldCreationScreenController : StateMachine("WorldCreationScreenController") {
        private var framebuffer = 0
        private val isDeserializing = false


        init {
            // State : GameConfigure
            addState(State(
                "GameConfigure",
                {},
                this,
                {
                    addw(gameCreationWindow)
                    Gdx.input.inputProcessor = stage
                },
                {
                    if (isConnecting) {
                        constructConnectingText()
                    } else if (isDeserializing or isLoading) {
                        constructDeserializingText()
                    } else {
                        constructGeneratingText()
                    }
                }
            ))
            // State : GameLoad
            addState(
                State(
                    "GameLoad",
                    {},
                    this,
                    {
                        chooser.show(stage)
                    },
                    null
                )
            )
            // Switch : from GameConfigure to GameLoad
            registerSwitchCondition(0, 1) { isLoading }
            // State : PreRender
            addState(
                State(
                    "PreRender",
                    { framebuffer++ },
                    this,
                    null,
                    null
                )
            )
            // State : GeneratingWorld
            addState(
                State(
                    "GeneratingWorld",
                    {},
                    this,
                    { doNewGameCallback() },
                    null
                )
            )
            // State : LanInit
            addState(
                State(
                    "LanInit",
                    {},
                    this,
                    { boot() },
                    null
                )
            )
            // State : LanConfigure
            addState(
                State(
                    "LanConfigure",
                    {},
                    this,
                    {
                        Gdx.input.inputProcessor = stage
                        stage.actors.removeValue(loadingContainer, true)
                        addw(W_NetworkConnect())
                    },
                    null
                )
            )
            // State : Deserializing
            addState(
                State(
                    "Deserializing",
                    {},
                    this,
                    {
                        if (isLoading)
                            load(Gdx.files.external(chooser.result.path()).file())
                    },
                    null
                )
            )
            // State : Complete
            addState(
                State(
                    "Complete",
                    {},
                    this,
                    { GameHypervisor.doNewGameFINAL() },
                    null
                )
            )
            // State : LanConnecting
            addState(
                State(
                    "LanConnecting",
                    {},
                    this,
                    { connect() },
                    null
                )
            )
            // Switch : from GameConfigure to PreRender
            registerSwitchCondition(0, 2) { Client.DEBUG_MODE or isConnecting }
            // Switch : from PreRender to Deserializing
            registerSwitchCondition(2, 6) { framebuffer >= 3 && isLoading }
            // Switch : from PreRender to GeneratingWorld
            registerSwitchCondition(2, 3) { framebuffer >= 3 && !isConnected() && !isLoading }
            // Switch : from PreRender to LanConnecting
            registerSwitchCondition(2, 8) { framebuffer >= 3 && isConnecting }
            // Switch : from LanInit to GameConfigure
            registerSwitchCondition(4, 0) { !alive }
            // Switch : from LanInit to PreRender
            registerSwitchCondition(4, 2) { alive }
            // Switch : from GeneratingWorld to LanConfigure
            registerSwitchCondition(3, 5) { alive }
            // Switch : from GeneratingWorld to Complete
            registerSwitchCondition(3, 7) { !alive }
            // Switch : from LanConnecting to Complete
            registerSwitchCondition(8, 7) { GameHypervisor.inGame }
            // Switch : from Deserializing to Complete
            registerSwitchCondition(6, 7) { true }
            defaultState(0)
        }
    }

    override fun doResize(width: Int, height: Int) {}
}