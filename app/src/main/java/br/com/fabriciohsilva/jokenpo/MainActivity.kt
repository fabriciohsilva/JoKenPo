package br.com.fabriciohsilva.jokenpo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val ROCK     = 0
    val PAPER    = 1
    val SCISSORS = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivRock.setOnClickListener {
            makeMove(ROCK)
        }//end ivRock.setOnClickListener

        ivPaper.setOnClickListener {
            makeMove(PAPER)
        }//end ivPaper.setOnClickListener

        ivScissors.setOnClickListener {
            makeMove(SCISSORS)
        }//end ivScissors.setOnClickListener

    }//end override fun onCreate


    private fun makeMove(yourMove: Int) {
        val androidMove = Random().nextInt(3)

        changeImages(yourMove, ivYou)
        changeImages(androidMove, ivAndroid)
        when (yourMove) {
            ROCK -> {
                when (androidMove) {
                    ROCK -> {
                        drew()
                    }
                    PAPER -> {
                        lose()
                    }
                    SCISSORS -> {
                        win()
                    }
                }
            }

            PAPER -> {
                when (androidMove) {
                    ROCK -> {
                        win()
                    }
                    PAPER -> {
                        drew()
                    }
                    SCISSORS -> {
                        lose()
                    }
                }
            }

            SCISSORS -> {
                when (androidMove) {
                    ROCK -> {
                        lose()
                    }
                    PAPER -> {
                        win()
                    }
                    SCISSORS -> {
                        drew()
                    }
                }
            }
        }
    }//end private fun makeMove

    private fun changeImages(move: Int, imgView: ImageView) {
        when (move) {
            ROCK -> {
                setImagem(R.drawable.pedra, imgView)
            }//end ROCK
            SCISSORS -> {
                setImagem(R.drawable.tesoura, imgView)
            }//end SCISSORS
            PAPER -> {
                setImagem(R.drawable.papel, imgView)
            }//end PAPER
        }//end when (move)
    }//end private fun changeImages

    private fun setImagem(icone: Int, imgView:ImageView) {
        imgView.setImageDrawable(ContextCompat.getDrawable(this, icone))
    }//end private fun setImagem

    private fun lose() {
        tvResult.text = "Perdeu"
    }//end lose

    private fun drew() {
        tvResult.text = "Empatou"
    }//end drew

    private fun win() {
        tvResult.text = "Ganhou"
    }//end win

}//end class MainActivity
