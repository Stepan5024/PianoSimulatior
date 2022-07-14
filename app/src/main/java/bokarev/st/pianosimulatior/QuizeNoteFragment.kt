package bokarev.st.pianosimulatior

import android.app.Activity
import android.content.res.Configuration
import android.content.res.Configuration.*
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [QuizeNoteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuizeNoteFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    // 110 - первая ступень (верхняя)
    // 160 - это вторая ступень
    val si = 210 // 210 - третья ступень нота си
    val lya = 235 // 235 нота ля
    val sol = 265 // 265 - четвертая ступень нота соль
    val fa = 295 // 295 - нота фа
    val mi = 325// 325 - пятая ступень нота ми
    val re = 360 // 360 - под пятой ступенью (самая нижняя) нота ре
    val n_do = 380 // 390 - нота до
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        /*mediaPlayer = MediaPlayer.create(context, R.raw.a3)
        mediaPlayer?.start()*/
        mediaPlayer?.setOnPreparedListener {}
        val view: View = inflater.inflate(R.layout.fragment_quize_note, container, false)
        /*val btn_save_score: Button = view.findViewById(R.id.button_save_score)
        btn_save_score.setOnClickListener {
            Toast.makeText(context, "score saved ${btn_save_score.isPressed}", Toast.LENGTH_SHORT)
                .show()
        }*/


        val button_play_music_note: Button = view.findViewById(R.id.button_play_music_note)

        var randomNumber = nextNote(view)


        val btn_selected_note: Button = view.findViewById(R.id.button_selected_note)

        button_play_music_note.setOnClickListener {
            // Toast.makeText(context, "sound note ${randomNumber}", Toast.LENGTH_SHORT).show() // work

            if (randomNumber == 0) {
                mediaPlayer = MediaPlayer.create(context, R.raw.c5)
                mediaPlayer?.start()

            } else if (randomNumber == 1) {
                mediaPlayer = MediaPlayer.create(context, R.raw.d5)
                mediaPlayer?.start()

            } else if (randomNumber == 2) {
                mediaPlayer = MediaPlayer.create(context, R.raw.e5)
                mediaPlayer?.start()

            } else if (randomNumber == 3) {
                mediaPlayer = MediaPlayer.create(context, R.raw.f5)
                mediaPlayer?.start()

            } else if (randomNumber == 4) {
                mediaPlayer = MediaPlayer.create(context, R.raw.g5)
                mediaPlayer?.start()

            } else if (randomNumber == 5) {
                mediaPlayer = MediaPlayer.create(context, R.raw.a5)
                mediaPlayer?.start()

            } else if (randomNumber == 6) {
                mediaPlayer = MediaPlayer.create(context, R.raw.b5)
                mediaPlayer?.start()

            }
        }
        val inputStream = if (isDarkTheme(context as Activity)) {
            //assets.open("priceTag_dark.png")
            //Toast.makeText(context, "Dark", Toast.LENGTH_SHORT).show() // work

        } else {
            //assets.open("priceTag_light.png")
            //Toast.makeText(context, "light", Toast.LENGTH_SHORT).show()
        }
        var score = 0
        var numberAttempt = 0
        val textViewOfScore: TextView = view.findViewById(R.id.text_score_of_quize)
        val layout_note_do: LinearLayout = view.findViewById(R.id.layout_note_do)
        layout_note_do.setOnClickListener {
            val params = btn_selected_note.layoutParams as ViewGroup.MarginLayoutParams
            if (params.topMargin == n_do && textViewOfScore.text.toString().toInt() < 10) {
                Toast.makeText(context, "Верно! Нота дo", Toast.LENGTH_SHORT).show()
                score++
                numberAttempt++
                textViewOfScore.setText("$score")
            } else if (textViewOfScore.text.toString().toInt() >= 10) {
                Toast.makeText(context, "У тебя 10 из 10. Все верно!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Не правильно, попробуй другую ноту", Toast.LENGTH_SHORT).show()
                numberAttempt++
            }

            randomNumber = nextNote(view)

        }

        val layout_note_re: LinearLayout = view.findViewById(R.id.layout_note_re)
        layout_note_re.setOnClickListener {
            val params = btn_selected_note.layoutParams as ViewGroup.MarginLayoutParams
            if (params.topMargin == re&& textViewOfScore.text.toString().toInt() < 10) {
                Toast.makeText(context, "Верно! Нота рe", Toast.LENGTH_SHORT).show()
                score++
                numberAttempt++
                textViewOfScore.setText("${score}")
            } else if (textViewOfScore.text.toString().toInt() >= 10) {
                Toast.makeText(context, "У тебя 10 из 10. Все верно!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Не правильно, попробуй другую ноту", Toast.LENGTH_SHORT).show()
                numberAttempt++
            }

            randomNumber = nextNote(view)
        }

        val layout_note_mi: LinearLayout = view.findViewById(R.id.layout_note_mi)
        layout_note_mi.setOnClickListener {
            val params = btn_selected_note.layoutParams as ViewGroup.MarginLayoutParams
            if (params.topMargin == mi&& textViewOfScore.text.toString().toInt() < 10) {
                Toast.makeText(context, "Верно! Нота ми", Toast.LENGTH_SHORT).show()
                score++
                numberAttempt++
                textViewOfScore.setText("$score")
            } else if (textViewOfScore.text.toString().toInt() >= 10) {
                Toast.makeText(context, "У тебя 10 из 10. Все верно!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Не правильно, попробуй другую ноту", Toast.LENGTH_SHORT).show()
                numberAttempt++
            }

            randomNumber = nextNote(view)
        }

        val layout_note_fa: LinearLayout = view.findViewById(R.id.layout_note_fa)
        layout_note_fa.setOnClickListener {
            val params = btn_selected_note.layoutParams as ViewGroup.MarginLayoutParams
            if (params.topMargin == fa&& textViewOfScore.text.toString().toInt() < 10) {
                Toast.makeText(context, "Верно! Нота фa", Toast.LENGTH_SHORT).show()
                score++
                numberAttempt++
                textViewOfScore.setText("$score")
            } else if (textViewOfScore.text.toString().toInt() >= 10) {
                Toast.makeText(context, "У тебя 10 из 10. Все верно!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Не правильно, попробуй другую ноту", Toast.LENGTH_SHORT).show()
                numberAttempt++
            }

            randomNumber = nextNote(view)
        }
        val layout_note_sol: LinearLayout = view.findViewById(R.id.layout_note_sol)
        layout_note_sol.setOnClickListener {
            val params = btn_selected_note.layoutParams as ViewGroup.MarginLayoutParams
            if (params.topMargin == sol&& textViewOfScore.text.toString().toInt() < 10) {
                Toast.makeText(context, "Верно! Нота соль", Toast.LENGTH_SHORT).show()
                score++
                numberAttempt++
                textViewOfScore.setText("$score")
            } else if (textViewOfScore.text.toString().toInt() >= 10) {
                Toast.makeText(context, "У тебя 10 из 10. Все верно!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Не правильно, попробуй другую ноту", Toast.LENGTH_SHORT).show()
                numberAttempt++
            }

            randomNumber = nextNote(view)
        }

        val layout_note_lya: LinearLayout = view.findViewById(R.id.layout_note_lya)
        layout_note_lya.setOnClickListener {
            val params = btn_selected_note.layoutParams as ViewGroup.MarginLayoutParams
            if (params.topMargin == lya&& textViewOfScore.text.toString().toInt() < 10) {
                Toast.makeText(context, "Верно! Нота ля", Toast.LENGTH_SHORT).show()
                score++
                numberAttempt++
                textViewOfScore.setText("$score")
            } else if (textViewOfScore.text.toString().toInt() >= 10) {
                Toast.makeText(context, "У тебя 10 из 10. Все верно!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Не правильно, попробуй другую ноту", Toast.LENGTH_SHORT).show()
                numberAttempt++
            }

            randomNumber = nextNote(view)
        }
        val layout_note_si: LinearLayout = view.findViewById(R.id.layout_note_si)
        layout_note_si.setOnClickListener {
            val params = btn_selected_note.layoutParams as ViewGroup.MarginLayoutParams
            if (params.topMargin == si&& textViewOfScore.text.toString().toInt() < 10) {
                Toast.makeText(context, "Верно! Нота си", Toast.LENGTH_SHORT).show()
                score++
                numberAttempt++
                textViewOfScore.setText("$score")
            } else if (textViewOfScore.text.toString().toInt() >= 10) {
                Toast.makeText(context, "У тебя 10 из 10. Все верно!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Не правильно, попробуй другую ноту", Toast.LENGTH_SHORT).show()
                numberAttempt++
            }

            randomNumber = nextNote(view)
        }

        return view
    }

    fun nextNote(view: View): Int {
        val randomNumber = RandomNumberWithKotlinNumberRange_thenResultInGivenRange()
        val btn_selected_note: Button = view.findViewById(R.id.button_selected_note)
        val params = btn_selected_note.layoutParams as ViewGroup.MarginLayoutParams

        when (randomNumber) {
            0 -> { // нота до
                params.topMargin = n_do

            }
            1 -> { // нота ре
                params.topMargin = re
            }
            2 -> { // нота ми
                params.topMargin = mi
            }
            3 -> { // нота фа
                params.topMargin = fa
            }
            4 -> { // нота соль
                params.topMargin = sol
            }
            5 -> { // нота ля
                params.topMargin = lya
            }
            6 -> { // нота си
                params.topMargin = si
            }
        }
        btn_selected_note.layoutParams = params // применить заданный отступ

        return randomNumber
    }

    fun RandomNumberWithKotlinNumberRange_thenResultInGivenRange(): Int {
        val randomInteger = (0..7).shuffled()
            .first() // Используя чистый Kotlin, мы можем создать список чисел, перетасовать его, а затем взять первый элемент t из этого списка:
        return if (randomInteger in 0..7) {
            randomInteger
        } else -1
    }

    fun isDarkTheme(activity: Activity): Boolean {
        return activity.resources.configuration.uiMode and
                UI_MODE_NIGHT_MASK == UI_MODE_NIGHT_YES
    }

    companion object {

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QuizeNoteFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QuizeNoteFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}