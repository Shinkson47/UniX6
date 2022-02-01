package com.shinkson47.SplashX6.desktop

import com.badlogic.gdx.Files.FileType
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.backends.lwjgl.LwjglFileHandle
import com.shinkson47.SplashX6.desktop.PreSplash
import java.awt.*
import java.io.IOException
import javax.imageio.ImageIO
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel

/**
 * <h1></h1>
 * <br></br>
 *
 *
 *
 *
 *
 * @author [Jordan T. Gray on 21/01/2022](https://www.shinkson47.in)
 * @version 1
 * @since v1
 */
class PreSplash : Runnable {
    private var StartTime = System.currentTimeMillis()
    private var splashScreenSuper: JFrame = JFrame()

    override fun run() {

        //Prepare Frame
        splashScreenSuper.getContentPane().add(JLabel(), BorderLayout.CENTER)
        splashScreenSuper.setUndecorated(true) //Make frame borderless
        splashScreenSuper.pack()

        //Paint image to frame
        var image: Image? //Widen image's scope
        image = try {
            ImageIO.read(javaClass.getResourceAsStream("/resources/main/sprites/bg.png")) //Read splash image
        } catch (e: IOException) {
            //EMSHelper.handleException(e)
            splashScreenSuper.dispose()
            return
        } //Failed to read image, don't display, dispose and return.


        splashScreenSuper.setSize(image!!.getWidth(null), image!!.getHeight(null)) //Responsively set size to splash image
        splashScreenSuper.setLocationRelativeTo(null)
        splashScreenSuper.setVisible(true) //Early visibility required for graphics object

        val splashPainter: Graphics = splashScreenSuper.getGraphics() //Get Graphics from the frame to paint the image
        splashPainter.drawImage(image, 0, 0, null) //Draw splash image to the graphics canvas
        splashPainter.setColor(Color.darkGray)
        splashPainter.setFont(Font.getFont("Monospaced"))
        splashPainter.drawString("yeet", 5, splashScreenSuper.getHeight() - 20)
        splashPainter.drawString(
            "Powered by OPEX V",
            5,
            splashScreenSuper.getHeight() - 5
        )

        splashPainter.drawString("Initialising Engine", 5, splashScreenSuper.getHeight() - 35)

        StartTime = System.currentTimeMillis()

        splashScreenSuper.isVisible = true;
        while (System.currentTimeMillis() - StartTime <= MIN_DISPLAY * displayMultiplyer) {}
        splashScreenSuper.setVisible(false) //hide
        splashScreenSuper.dispose() //dispose
        Thread.currentThread().interrupt()
    }

    companion object {

        private const val MIN_DISPLAY = 1000L //default and minimum.
        private var displayMultiplyer = 3L

        /**
         * Sets the multiplier for minimum display length.
         *
         * Multiplier is equal to the minimum display time in seconds;
         * i.e multiplier 1L results 1 second minimum display time.
         *
         * minimum display time = (1000L * multiplier)
         *
         * Once minimum display time has passed, the splash will close the instant the
         * engine declares sucessfuls startup.
         *
         * If the engine completed before the splash has closed, it will wait for the splash
         * to close before executing post startup and client payloads.
         * @param multiplyer
         */
        fun setDisplayMultiplyer(multiplyer: Long) {
            displayMultiplyer = multiplyer
        }
    }
}