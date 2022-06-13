package com.smdsa.encyclopedia

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.smdsa.encyclopedia.databinding.ActivityMicrophoneClassBinding
import android.media.MediaRecorder
import android.widget.Switch
import java.io.File

class MicrophoneClass : AppCompatActivity() {

    private lateinit var binding: ActivityMicrophoneClassBinding
    private var output: String? = null
    private var mediaRecorder: MediaRecorder? = null
    private var state: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMicrophoneClassBinding.inflate(layoutInflater)
        setContentView(binding.root)
        try{
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.RECORD_AUDIO), 0);

            }
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.RECORD_AUDIO,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE),0)
            }
            val path = this.getExternalFilesDir(null)
            val letDirectory = File(path, "Records")
            letDirectory.mkdirs()
            val file = File(letDirectory, "recording.mp3")
            mediaRecorder = MediaRecorder()
            mediaRecorder?.setAudioSource(MediaRecorder.AudioSource.MIC)
            mediaRecorder?.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
            mediaRecorder?.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
            mediaRecorder?.setOutputFile(file.toString())

            binding.floatingActionButton.setOnClickListener {
                startRecording()
            }
            binding.floatingActionButton2.setOnClickListener {
                stopRecording()
            }
        }
        catch (ex: Exception){
            Toast.makeText(this,"i want $ex", Toast.LENGTH_SHORT).show()
        }

    }

    private fun startRecording() {
        mediaRecorder?.prepare()
        mediaRecorder?.start()
        state = true
        Toast.makeText(this, "Recording started!", Toast.LENGTH_SHORT).show()
    }

    private fun stopRecording(){
        if (state) {
            mediaRecorder?.stop()
            mediaRecorder?.release()
            state = false
            Toast.makeText(this, "You are stop recording!", Toast.LENGTH_SHORT).show()
        }
    }
}