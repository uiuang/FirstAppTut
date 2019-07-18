package com.zsc7454.firstapptut

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val initialTextTranslationY = textView_progress.translationY
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textView_progress.text = progress.toString()

                val transientDistance =
                    (initialTextTranslationY + progress * resources.getDimension(R.dimen.text_anim_step) * -1)
                textView_progress.animate().translationY(transientDistance)
                if (!fromUser)
                    textView_progress.animate().setStartDelay(500).rotationBy(360f)
                        .translationY(initialTextTranslationY)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        button_reset.setOnClickListener { v ->
            seekBar.progress = 0

        }
    }
}
