import java.io.File
import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.Clip

fun main() {
    val soundMap = mapOf(
        'a' to "sound1.wav",
        'b' to "sound2.wav",
        'c' to "sound3.wav"
        // Add more sounds and key mappings here if needed
    )

    val scanner = java.util.Scanner(System.`in`)
    println("Welcome to the Soundboard App!")
    println("Press the corresponding key to play the sound (or type 'exit' to quit)")

    while (true) {
        val input = scanner.nextLine()
        if (input == "exit") {
            println("Exiting Soundboard App. Goodbye!")
            break
        } else {
            val soundFile = soundMap[input[0]]
            if (soundFile != null) {
                playSound(soundFile)
            } else {
                println("Invalid key. Press 'a', 'b', 'c' to play sounds.")
            }
        }
    }
}

fun playSound(soundFileName: String) {
    try {
        val soundFile = File(soundFileName)
        val audioInputStream: AudioInputStream = AudioSystem.getAudioInputStream(soundFile)
        val clip: Clip = AudioSystem.getClip()
        clip.open(audioInputStream)
        clip.start()
    } catch (e: Exception) {
        println("Error playing sound: ${e.message}")
    }
}
