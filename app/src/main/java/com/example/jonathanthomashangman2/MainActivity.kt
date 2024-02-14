package com.example.jonathanthomashangman2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.example.jonathanthomashangman2.databinding.ActivityMainBinding
import java.util.LinkedList
import kotlin.properties.Delegates
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val hangmanViewModel: HangmanViewModel by viewModels()

    private val newhang = listOf(
        R.drawable.hang_empty3,
        R.drawable.hang_head,
        R.drawable.hang_body,
        R.drawable.hang_larm,
        R.drawable.hang_rarm,
        R.drawable.hang_lleg,
        R.drawable.hang_rleg)

    private val wordBank = listOf(
        Word(R.string.word1, listOf('A', 'P', 'P', 'L', 'E'), listOf(0, 15, 15, 11, 4),5, "Fruit"),
        Word(R.string.word2, listOf('B', 'A', 'C', 'K', 'P','A','C','K'), listOf(1, 0, 2, 10, 15, 0, 2, 10),8, "School Supply"),
        Word(R.string.word3, listOf('C', 'A', 'T'), listOf(2, 0, 19),3, "Animal"))

    private lateinit var aListener: View.OnClickListener
    private lateinit var eListener: View.OnClickListener
    private lateinit var iListener: View.OnClickListener
    private lateinit var oListener: View.OnClickListener
    private lateinit var uListener: View.OnClickListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("VM", "Got a HangmanViewModel: $hangmanViewModel")

        displayGame()
        //Log.d("bz", binding.buttonZ.isEnabled.toString())

        binding.newgame?.setOnClickListener {
            var rand : Int
            do {
                rand = Random.nextInt(0, wordBank.size)
            } while (rand == hangmanViewModel.getCurrentWord)
            hangmanViewModel.setWord(rand)
            
            hangmanViewModel.resetHang()
            
            hangmanViewModel.setRem(wordBank[rand].length)

            hangmanViewModel.setInstr(R.string.instr2)

            hangmanViewModel.resetLetters()

            hangmanViewModel.resetButtons()

            hangmanViewModel.setHint()

            hangmanViewModel.setHintVis(View.INVISIBLE)

            hangmanViewModel.resetNumDisabled()

            hangmanViewModel.setHintIndex(0)
            
            displayGame()

        }

        aListener = View.OnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'A') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_a)
                    hangmanViewModel.setLetter(i, R.drawable.bar_a)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()

            binding.buttonA.setImageResource(R.drawable.button_a_disabled_blue)
            binding.buttonA.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(0, R.drawable.button_a_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)
        }

        binding.buttonA.setOnClickListener(aListener)

        /*binding.buttonA.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'A') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_a)
                    hangmanViewModel.setLetter(i, R.drawable.bar_a)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
            }

            binding.buttonA.setImageResource(R.drawable.button_a_disabled_blue)
            binding.buttonA.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(0, R.drawable.button_a_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)

        }*/

        binding.buttonB?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'B') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_b)
                    hangmanViewModel.setLetter(i, R.drawable.bar_b)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()

            binding.buttonB!!.setImageResource(R.drawable.button_b_disabled_blue)
            binding.buttonB!!.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(1, R.drawable.button_b_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)

        }

        binding.buttonC?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'C') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_c)
                    hangmanViewModel.setLetter(i, R.drawable.bar_c)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()

            binding.buttonC!!.setImageResource(R.drawable.button_c_disabled_blue)
            binding.buttonC!!.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(2, R.drawable.button_c_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)

        }

        binding.buttonD?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'D') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_d)
                    hangmanViewModel.setLetter(i, R.drawable.bar_d)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()

            binding.buttonD!!.setImageResource(R.drawable.button_d_disabled_blue)
            binding.buttonD!!.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(3, R.drawable.button_d_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)

        }

        eListener = View.OnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'E') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_e)
                    hangmanViewModel.setLetter(i, R.drawable.bar_e)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
            }

            binding.buttonE.setImageResource(R.drawable.button_e_disabled_blue)
            binding.buttonE.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(4, R.drawable.button_e_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)
        }

        binding.buttonE.setOnClickListener(eListener)

        /*binding.buttonE?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'E') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_e)
                    hangmanViewModel.setLetter(i, R.drawable.bar_e)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()

            binding.buttonE!!.setImageResource(R.drawable.button_e_disabled_blue)
            binding.buttonE!!.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(4, R.drawable.button_e_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)

        }*/

        binding.buttonF?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'F') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_f)
                    hangmanViewModel.setLetter(i, R.drawable.bar_f)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()

            binding.buttonF!!.setImageResource(R.drawable.button_f_disabled_blue)
            binding.buttonF!!.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(5, R.drawable.button_f_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)

        }

        binding.buttonG?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'G') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_g)
                    hangmanViewModel.setLetter(i, R.drawable.bar_g)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()

            binding.buttonG!!.setImageResource(R.drawable.button_g_disabled_blue)
            binding.buttonG!!.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(6, R.drawable.button_g_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)

        }

        binding.buttonH?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'H') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_h)
                    hangmanViewModel.setLetter(i, R.drawable.bar_h)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()

            binding.buttonH!!.setImageResource(R.drawable.button_h_disabled_blue)
            binding.buttonH!!.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(7, R.drawable.button_h_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)

        }

        iListener = View.OnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'I') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_i)
                    hangmanViewModel.setLetter(i, R.drawable.bar_i)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
            }

            binding.buttonI.setImageResource(R.drawable.button_i_disabled_blue)
            binding.buttonI.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(8, R.drawable.button_i_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)
        }

        binding.buttonI.setOnClickListener(iListener)

        /*binding.buttonI?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'I') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_i)
                    hangmanViewModel.setLetter(i, R.drawable.bar_i)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()

            binding.buttonI!!.setImageResource(R.drawable.button_i_disabled_blue)
            binding.buttonI!!.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(8, R.drawable.button_i_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)

        }*/

        binding.buttonJ?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'J') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_j)
                    hangmanViewModel.setLetter(i, R.drawable.bar_j)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()

            binding.buttonJ!!.setImageResource(R.drawable.button_j_disabled_blue)
            binding.buttonJ!!.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(9, R.drawable.button_j_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)

        }

        binding.buttonK?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'K') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_k)
                    hangmanViewModel.setLetter(i, R.drawable.bar_k)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()

            binding.buttonK!!.setImageResource(R.drawable.button_k_disabled_blue)
            binding.buttonK!!.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(10, R.drawable.button_k_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)

        }

        binding.buttonL?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'L') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_l)
                    hangmanViewModel.setLetter(i, R.drawable.bar_l)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()

            binding.buttonL!!.setImageResource(R.drawable.button_l_disabled_blue)
            binding.buttonL!!.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(11, R.drawable.button_l_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)

        }

        binding.buttonM?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'M') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_m)
                    hangmanViewModel.setLetter(i, R.drawable.bar_m)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()

            binding.buttonM!!.setImageResource(R.drawable.button_m_disabled_blue)
            binding.buttonM!!.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(12, R.drawable.button_m_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)

        }

        binding.buttonN?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'N') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_n)
                    hangmanViewModel.setLetter(i, R.drawable.bar_n)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()

            binding.buttonN!!.setImageResource(R.drawable.button_n_disabled_blue)
            binding.buttonN!!.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(13, R.drawable.button_n_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)

        }

        oListener = View.OnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'O') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_o)
                    hangmanViewModel.setLetter(i, R.drawable.bar_o)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
            }

            binding.buttonO.setImageResource(R.drawable.button_o_disabled_blue)
            binding.buttonO.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(14, R.drawable.button_o_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)
        }

        binding.buttonO.setOnClickListener(oListener)

        /*binding.buttonO?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'O') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_o)
                    hangmanViewModel.setLetter(i, R.drawable.bar_o)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()

            binding.buttonO!!.setImageResource(R.drawable.button_o_disabled_blue)
            binding.buttonO!!.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(14, R.drawable.button_o_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)

        }*/

        binding.buttonP?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'P') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_p)
                    hangmanViewModel.setLetter(i, R.drawable.bar_p)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()

            binding.buttonP!!.setImageResource(R.drawable.button_p_disabled_blue)
            binding.buttonP!!.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(15, R.drawable.button_p_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)

        }

        binding.buttonQ?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'Q') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_q)
                    hangmanViewModel.setLetter(i, R.drawable.bar_q)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()

            binding.buttonQ!!.setImageResource(R.drawable.button_q_disabled_blue)
            binding.buttonQ!!.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(16, R.drawable.button_q_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)

        }

        binding.buttonR?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'R') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_r)
                    hangmanViewModel.setLetter(i, R.drawable.bar_r)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()

            binding.buttonR!!.setImageResource(R.drawable.button_r_disabled_blue)
            binding.buttonR!!.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(17, R.drawable.button_r_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)

        }

        binding.buttonS?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'S') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_s)
                    hangmanViewModel.setLetter(i, R.drawable.bar_s)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()

            binding.buttonS!!.setImageResource(R.drawable.button_s_disabled_blue)
            binding.buttonS!!.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(18, R.drawable.button_s_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)

        }

        binding.buttonT?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'T') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_t)
                    hangmanViewModel.setLetter(i, R.drawable.bar_t)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()

            binding.buttonT!!.setImageResource(R.drawable.button_t_disabled_blue)
            binding.buttonT!!.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(19, R.drawable.button_t_disabled_blue, false)
            //Log.d("rem", hangmanViewModel.getRem.toString())
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)

        }

        uListener = View.OnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'U') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_u)
                    hangmanViewModel.setLetter(i, R.drawable.bar_u)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
            }

            binding.buttonU.setImageResource(R.drawable.button_u_disabled_blue)
            binding.buttonU.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(20, R.drawable.button_u_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)
        }

        binding.buttonU.setOnClickListener(uListener)

        /*binding.buttonU?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'U') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_u)
                    hangmanViewModel.setLetter(i, R.drawable.bar_u)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()

            binding.buttonU!!.setImageResource(R.drawable.button_u_disabled_blue)
            binding.buttonU!!.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(20, R.drawable.button_u_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)

        }*/

        binding.buttonV?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'V') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_v)
                    hangmanViewModel.setLetter(i, R.drawable.bar_v)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()

            binding.buttonV!!.setImageResource(R.drawable.button_v_disabled_blue)
            binding.buttonV!!.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(21, R.drawable.button_v_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)

        }

        binding.buttonW?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'W') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_w)
                    hangmanViewModel.setLetter(i, R.drawable.bar_w)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()

            binding.buttonW!!.setImageResource(R.drawable.button_w_disabled_blue)
            binding.buttonW!!.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(22, R.drawable.button_w_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)

        }

        binding.buttonX?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'X') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_x)
                    hangmanViewModel.setLetter(i, R.drawable.bar_x)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()

            binding.buttonX!!.setImageResource(R.drawable.button_x_disabled_blue)
            binding.buttonX!!.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(23, R.drawable.button_x_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)

        }

        binding.buttonY?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'Y') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_y)
                    hangmanViewModel.setLetter(i, R.drawable.bar_y)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()

            binding.buttonY!!.setImageResource(R.drawable.button_y_disabled_blue)
            binding.buttonY!!.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(24, R.drawable.button_y_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)

        }

        binding.buttonZ?.setOnClickListener {
            var found = false
            for (i in 0..<wordBank[hangmanViewModel.getCurrentWord].length) {
                if ( wordBank[hangmanViewModel.getCurrentWord].ls[i] == 'Z') {
                    findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId).setImageResource(R.drawable.bar_z)
                    hangmanViewModel.setLetter(i, R.drawable.bar_z)
                    found = true
                    hangmanViewModel.decrRem()
                }
            }
            if (!found) {
                binding.hang.setImageResource(newhang[hangmanViewModel.getNextHang])
                hangmanViewModel.incrHang()
                Toast.makeText(
                    this,
                    R.string.incorrect_toast,
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    this,
                    R.string.correct_toast,
                    Toast.LENGTH_SHORT
                ).show()

            binding.buttonZ!!.setImageResource(R.drawable.button_z_disabled_blue)
            binding.buttonZ!!.isEnabled = false
            hangmanViewModel.incrNumDisabled()
            hangmanViewModel.setButton(25, R.drawable.button_z_disabled_blue, false)
            isDone(hangmanViewModel.getRem, hangmanViewModel.getNextHang)

        }

        binding.buttonhint?.setOnClickListener() {
            Log.d("remainder", hangmanViewModel.getRem.toString())
            Log.d("hintindex", hangmanViewModel.getHintIndex.toString())
            if (hangmanViewModel.getHintIndex == 0) {
                binding.hint?.visibility = View.VISIBLE
                hangmanViewModel.setHintVis(View.VISIBLE)
                hangmanViewModel.setHintIndex(1)
            } else if (hangmanViewModel.getHintIndex == 1) {
                if (hangmanViewModel.getNextHang == 6) {
                    // toast
                    Toast.makeText(
                        this,
                        R.string.hint_toast,
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    disableHalfButtons()
                    binding.hang?.setImageResource(newhang[hangmanViewModel.getNextHang])
                    hangmanViewModel.incrHang()
                    hangmanViewModel.setHintIndex(2)
                }
            } else if (hangmanViewModel.getHintIndex == 2) {
                if (hangmanViewModel.getNextHang == 6) {
                    // toast
                    Toast.makeText(
                        this,
                        R.string.hint_toast,
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    showVowels()
                    binding.hang?.setImageResource(newhang[hangmanViewModel.getNextHang])
                    hangmanViewModel.incrHang()
                    binding.buttonhint!!.isEnabled = false
                    hangmanViewModel.setButtonHint(false)
                }
            }
        }

    }

    private fun displayGame() {

        Log.d("newhang", newhang.toString())
        displayHang()
        displayLetters()
        displayButtons()
        findViewById<TextView>(R.id.instructions).text = getString(hangmanViewModel.getInstr)

        displayHints()

     }


    private fun displayHang() {
        if (hangmanViewModel.getNextHang == 0) {
            findViewById<ImageView>(R.id.hang).setImageResource(newhang[hangmanViewModel.getNextHang])
            hangmanViewModel.incrHang()
        }
        else
            findViewById<ImageView>(R.id.hang).setImageResource(newhang[hangmanViewModel.getNextHang - 1])
    }

    private fun displayLetters() {

        for (i in 0..8) {
            var letter = findViewById<ImageView>(hangmanViewModel.getLetter(i).letterId)
            letter.setImageResource(hangmanViewModel.getLetter(i).imageId)
            if (i < wordBank[hangmanViewModel.getCurrentWord].length)
                letter.visibility = View.VISIBLE
            else
                letter.visibility = View.INVISIBLE
        }
    }

    private fun displayButtons() {
        for (i in 0..25) {
            var button = findViewById<ImageView>(hangmanViewModel.getButton(i).buttonId)
            button.setImageResource(hangmanViewModel.getButton(i).imageId)
            button.isEnabled = hangmanViewModel.getButton(i).enabled
        }
    }

    private fun displayHints() {
        var hints = findViewById<TextView>(R.id.hint)
        var buttonHint = findViewById<Button>(R.id.buttonhint)
        if (hints != null) {
            hints.text = hangmanViewModel.getHint
            hints.visibility = hangmanViewModel.getHintVis
            buttonHint.isEnabled = hangmanViewModel.getButtonHint
        }

    }

    private fun isDone(rem: Int, nextHang: Int): Boolean {
        var instr = findViewById<TextView>(R.id.instructions)

        if (rem == 0) {
            instr.text = getString(R.string.instr3)
            hangmanViewModel.setInstr(R.string.instr3)
            disableButtons()
            return true
        }
        if (nextHang > 6) {
            instr.text = getString(R.string.instr4)
            hangmanViewModel.setInstr(R.string.instr4)
            disableButtons()
            return true
        }
        return false
    }
    
    private fun disableButtons() {

        for (i in 0..25) {
            findViewById<ImageView>(hangmanViewModel.getButton(i).buttonId).isEnabled = false
            hangmanViewModel.setButton(i, hangmanViewModel.getButton(i).imageId, false)
        }
        var buttonHint = findViewById<Button>(R.id.buttonhint)
        if (buttonHint != null)
            buttonHint.isEnabled = false
        hangmanViewModel.setButtonHint(false)
    }

    private fun disableHalfButtons() {
        val numDisabled = hangmanViewModel.getNumDisabled
        Log.d("initdis", numDisabled.toString())
        val half = (26 - numDisabled) / 2
        var disabled = mutableListOf<Int>()
        var count = 0
        while (count < half) {
            var rand = Random.nextInt(0, 26)
            if (rand !in disabled && rand !in wordBank[hangmanViewModel.getCurrentWord].mip) {
                count += 1
                disabled.add(rand)
                val buttonId = resources.getIdentifier("button${(65 + rand).toChar()}", "id", packageName)
                val imageId = resources.getIdentifier("button_${(97 + rand).toChar()}_disabled_blue", "drawable", packageName)
                findViewById<ImageView>(buttonId).isEnabled = false
                findViewById<ImageView>(buttonId).setImageResource(imageId)
                hangmanViewModel.setButton(rand, imageId, false)
                hangmanViewModel.incrNumDisabled()
            }
        }
        Log.d("findis", hangmanViewModel.getNumDisabled.toString())
    }

    private fun showVowels() {

        if(0 in wordBank[hangmanViewModel.getCurrentWord].mip) {
            aListener.onClick(null)
        }
        if(4 in wordBank[hangmanViewModel.getCurrentWord].mip) {
            eListener.onClick(null)
        }
        if(8 in wordBank[hangmanViewModel.getCurrentWord].mip) {
            iListener.onClick(null)
        }
        if(14 in wordBank[hangmanViewModel.getCurrentWord].mip) {
            oListener.onClick(null)
        }
        if(20 in wordBank[hangmanViewModel.getCurrentWord].mip) {
            uListener.onClick(null)
        }
    }

}