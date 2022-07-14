package bokarev.st.pianosimulatior

import android.media.SoundPool
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.HorizontalScrollView
import android.widget.ImageButton
import java.nio.file.Files.size

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PianoModeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PianoModeFragment : Fragment(), View.OnClickListener {

    private var c3 = 0
    private var c3Black: Int = 0
    private var d3: Int = 0
    private var d3Black: Int = 0
    private var e3: Int = 0
    private var f3: Int = 0
    private var f3Black: Int = 0
    private var g3: Int = 0
    private var g3Black: Int = 0
    private var a3: Int = 0
    private var a3Black: Int = 0
    private var b3: Int = 0
    private var c4 = 0
    private var c4Black: Int = 0
    private var d4: Int = 0
    private var d4Black: Int = 0
    private var e4: Int = 0
    private var f4: Int = 0
    private var f4Black: Int = 0
    private var g4: Int = 0
    private var g4Black: Int = 0
    private var a4: Int = 0
    private var a4Black: Int = 0
    private var b4: Int = 0
    private var c5 = 0
    private var c5Black: Int = 0
    private var d5: Int = 0
    private var d5Black: Int = 0
    private var e5: Int = 0
    private var f5: Int = 0
    private var f5Black: Int = 0
    private var g5: Int = 0
    private var g5Black: Int = 0
    private var a5: Int = 0
    private var a5Black: Int = 0
    private var b5: Int = 0
    private var c6 = 0
    private var c6Black: Int = 0
    private var d6: Int = 0
    private var d6Black: Int = 0
    private var e6: Int = 0
    private var f6: Int = 0
    private var f6Black: Int = 0
    private var g6: Int = 0
    private var g6Black: Int = 0
    private var a6: Int = 0
    private var a6Black: Int = 0
    private var b6: Int = 0
    private var c7 = 0
    private var c7Black: Int = 0
    private var d7: Int = 0
    private var d7Black: Int = 0
    private var e7: Int = 0
    private var f7: Int = 0
    private var f7Black: Int = 0
    private var g7: Int = 0
    private var g7Black: Int = 0
    private var a7: Int = 0
    private var a7Black: Int = 0
    private var b7: Int = 0
    private lateinit var soundPool: SoundPool

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        soundPool = SoundPool.Builder().setMaxStreams(6).build()

        sounds()
        //soundPool.play(b5, 1f, 1f, 0, 0, 1f)



    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_piano_mode, container, false)
        val id_buttons = arrayOf(
            R.id.p1,
            R.id.p2,
            R.id.p3,
            R.id.p4,
            R.id.p5,
            R.id.p6,
            R.id.p7,
            R.id.p8,
            R.id.p9,
            R.id.p10,
            R.id.p11,
            R.id.p12,
            R.id.p13,
            R.id.p14,
            R.id.p15,
            R.id.p16,
            R.id.p17,
            R.id.p18,
            R.id.p19,
            R.id.p20,
            R.id.p21,
            R.id.p22,
            R.id.p23,
            R.id.p24,
            R.id.p25,
            R.id.p26,
            R.id.p27,
            R.id.p28,
            R.id.p29,
            R.id.p30,
            R.id.p31,
            R.id.p32,
            R.id.p33,
            R.id.p34,
            R.id.p35,
            R.id.b1,
            R.id.b2,
            R.id.b4,
            R.id.b5,
            R.id.b6,
            R.id.b8,
            R.id.b9,
            R.id.b11,
            R.id.b12,R.id.b13,
            R.id.b15,
            R.id.b16,R.id.b18,
            R.id.b19,
            R.id.b20,
            R.id.b22,
            R.id.b23,
            R.id.b25,
            R.id.b26,
            R.id.b27,
            R.id.b29,
            R.id.b30,
            R.id.b32,
            R.id.b33,
            R.id.b34,

        )
        // и дальше в коде

        for (i in 0 until id_buttons.size) {
            val ibtn: Button = view.findViewById(id_buttons[i])
            ibtn.setOnClickListener(this)
        }


        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PianoModeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PianoModeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    fun record(view: View) {}

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tc3 -> soundPool.play(c3, 1f, 1f, 0, 0, 1f)
            R.id.p1 ->
                soundPool.play(c3, 1f, 1f, 0, 0, 1f)


            R.id.b1 ->
                soundPool.play(c3Black, 1f, 1f, 0, 0, 1f)

            R.id.td3 -> soundPool.play(d3, 1f, 1f, 0, 0, 1f)
            R.id.p2 ->
                soundPool.play(d3, 1f, 1f, 0, 0, 1f)

            R.id.b2 ->
                soundPool.play(d3Black, 1f, 1f, 0, 0, 1f)

            R.id.te3 -> soundPool.play(e3, 1f, 1f, 1, 0, 1f)
            R.id.p3 ->
                soundPool.play(e3, 1f, 1f, 1, 0, 1f)

            R.id.tf3 -> soundPool.play(f3, 1f, 1f, 0, 0, 1f)
            R.id.p4 ->
                soundPool.play(f3, 1f, 1f, 0, 0, 1f)

            R.id.b4 ->
                soundPool.play(f3Black, 1f, 1f, 0, 0, 1f)

            R.id.tg3 -> soundPool.play(g3, 1f, 1f, 0, 0, 1f)
            R.id.p5 ->
                soundPool.play(g3, 1f, 1f, 0, 0, 1f)

            R.id.b5 ->
                soundPool.play(g3Black, 1f, 1f, 0, 0, 1f)

            R.id.ta3 -> soundPool.play(a3, 1f, 1f, 0, 0, 1f)
            R.id.p6 ->
                soundPool.play(a3, 1f, 1f, 0, 0, 1f)


            R.id.b6 ->
                soundPool.play(a3Black, 1f, 1f, 0, 0, 1f)


            R.id.tb3 -> soundPool.play(b3, 1f, 1f, 0, 0, 1f)
            R.id.p7 ->
                soundPool.play(b3, 1f, 1f, 0, 0, 1f)

            R.id.tc4 -> soundPool.play(c4, 1f, 1f, 0, 0, 1f)
            R.id.p8 ->
                soundPool.play(c4, 1f, 1f, 0, 0, 1f)

            R.id.b8 ->
                soundPool.play(c4Black, 1f, 1f, 0, 0, 1f)


            R.id.td4 -> soundPool.play(d4, 1f, 1f, 0, 0, 1f)
            R.id.p9 ->
                soundPool.play(d4, 1f, 1f, 0, 0, 1f)


            R.id.b9 ->
                soundPool.play(d4Black, 1f, 1f, 0, 0, 1f)

            R.id.te4 -> soundPool.play(e4, 1f, 1f, 0, 0, 1f)
            R.id.p10 ->
                soundPool.play(e4, 1f, 1f, 0, 0, 1f)

            R.id.tf4 -> soundPool.play(f4, 1f, 1f, 0, 0, 1f);
            R.id.p11 ->
                soundPool.play(f4, 1f, 1f, 0, 0, 1f);


            R.id.b11 ->
                soundPool.play(f4Black, 1f, 1f, 0, 0, 1f)


            R.id.tg4 -> soundPool.play(g4, 1f, 1f, 0, 0, 1f)
            R.id.p12 ->
                soundPool.play(g4, 1f, 1f, 0, 0, 1f)


            R.id.b13 ->
                soundPool.play(g4Black, 1f, 1f, 0, 0, 1f)


            R.id.ta4 -> soundPool.play(a4, 1f, 1f, 0, 0, 1f)
            R.id.p13 ->
                soundPool.play(a4, 1f, 1f, 0, 0, 1f)


            R.id.b15 ->
                soundPool.play(a4Black, 1f, 1f, 0, 0, 1f)


            R.id.tb4 -> soundPool.play(b4, 1f, 1f, 0, 0, 1f)
            R.id.p14 ->
                soundPool.play(b4, 1f, 1f, 0, 0, 1f)


            R.id.tc5 -> soundPool.play(c5, 1f, 1f, 0, 0, 1f)
            R.id.p15 ->
                soundPool.play(c5, 1f, 1f, 0, 0, 1f)

            R.id.b16 ->
                soundPool.play(c5Black, 1f, 1f, 0, 0, 1f)


            R.id.td5 -> soundPool.play(d5, 1f, 1f, 0, 0, 1f)
            R.id.p16 ->
                soundPool.play(d5, 1f, 1f, 0, 0, 1f)


            R.id.b18 ->
                soundPool.play(d5Black, 1f, 1f, 0, 0, 1f)


            R.id.te5 -> soundPool.play(d5, 1f, 1f, 0, 0, 1f)
            R.id.p17 ->
                soundPool.play(d5, 1f, 1f, 0, 0, 1f)

            R.id.tf5 -> soundPool.play(d5, 1f, 1f, 0, 0, 1f)
            R.id.p18 ->
                soundPool.play(d5, 1f, 1f, 0, 0, 1f)


            R.id.b19 ->
                soundPool.play(f5Black, 1f, 1f, 0, 0, 1f)


            R.id.tg5 -> soundPool.play(d5, 1f, 1f, 0, 0, 1f)
            R.id.p19 ->
                soundPool.play(d5, 1f, 1f, 0, 0, 1f)

            R.id.b20 ->
                soundPool.play(g5Black, 1f, 1f, 0, 0, 1f)


            R.id.ta5 -> soundPool.play(d5, 1f, 1f, 0, 0, 1f)
            R.id.p20 ->
                soundPool.play(d5, 1f, 1f, 0, 0, 1f)


            R.id.b22 ->
                soundPool.play(a5Black, 1f, 1f, 0, 0, 1f)


            R.id.tb5 -> soundPool.play(d5, 1f, 1f, 0, 0, 1f)
            R.id.p21 ->
                soundPool.play(d5, 1f, 1f, 0, 0, 1f)

            R.id.tc6 -> soundPool.play(d5, 1f, 1f, 0, 0, 1f)
            R.id.b23 ->
                soundPool.play(d5, 1f, 1f, 0, 0, 1f)


            R.id.b27 -> soundPool.play(d5, 1f, 1f, 0, 0, 1f)


            R.id.td6 -> soundPool.play(d5, 1f, 1f, 0, 0, 1f)
            R.id.p23 ->
                soundPool.play(d5, 1f, 1f, 0, 0, 1f)


            R.id.b25 ->
                soundPool.play(d6Black, 1f, 1f, 0, 0, 1f)


            R.id.te6 -> soundPool.play(d5, 1f, 1f, 0, 0, 1f)
            R.id.p24 ->
                soundPool.play(d5, 1f, 1f, 0, 0, 1f)

            R.id.tf6 -> soundPool.play(d5, 1f, 1f, 0, 0, 1f)
            R.id.p25 ->
                soundPool.play(d5, 1f, 1f, 0, 0, 1f)


            R.id.b26 ->
                soundPool.play(f6Black, 1f, 1f, 0, 0, 1f)


            R.id.tg6 -> soundPool.play(d5, 1f, 1f, 0, 0, 1f)
            R.id.p26 ->
                soundPool.play(d5, 1f, 1f, 0, 0, 1f)


            R.id.b27 ->
                soundPool.play(g6Black, 1f, 1f, 0, 0, 1f)


            R.id.ta6 -> soundPool.play(a6, 1f, 1f, 0, 0, 1f)
            R.id.p27 ->
                soundPool.play(a6, 1f, 1f, 0, 0, 1f)

            R.id.b29 ->
                soundPool.play(a6Black, 1f, 1f, 0, 0, 1f)


            R.id.tb6 -> soundPool.play(a6, 1f, 1f, 0, 0, 1f)
            R.id.p28 ->
                soundPool.play(a6, 1f, 1f, 0, 0, 1f)

            R.id.tc7 -> soundPool.play(a6, 1f, 1f, 0, 0, 1f)
            R.id.p29 ->
                soundPool.play(a6, 1f, 1f, 0, 0, 1f)

            R.id.b30 ->
                soundPool.play(c7Black, 1f, 1f, 0, 0, 1f)


            R.id.td7 -> soundPool.play(a6, 1f, 1f, 0, 0, 1f)
            R.id.p30 ->
                soundPool.play(a6, 1f, 1f, 0, 0, 1f)


            R.id.b32 ->
                soundPool.play(d7Black, 1f, 1f, 0, 0, 1f)


            R.id.te7 -> soundPool.play(a6, 1f, 1f, 0, 0, 1f)
            R.id.p31 ->
                soundPool.play(e7, 1f, 1f, 0, 0, 1f)


            R.id.tf7 -> soundPool.play(a6, 1f, 1f, 0, 0, 1f)
            R.id.p32 ->
                soundPool.play(e7, 1f, 1f, 0, 0, 1f)


            R.id.b33 ->
                soundPool.play(f7Black, 1f, 1f, 0, 0, 1f)


            R.id.tg7 -> soundPool.play(a6, 1f, 1f, 0, 0, 1f)
            R.id.p33 ->
                soundPool.play(e7, 1f, 1f, 0, 0, 1f)


            R.id.b34 ->
                soundPool.play(g7Black, 1f, 1f, 0, 0, 1f)

            R.id.ta7 -> soundPool.play(a6, 1f, 1f, 0, 0, 1f)
            R.id.p34 ->
                soundPool.play(e7, 1f, 1f, 0, 0, 1f)


            R.id.b12 ->
                soundPool.play(a7Black, 1f, 1f, 0, 0, 1f)

            R.id.tb7 -> soundPool.play(a6, 1f, 1f, 0, 0, 1f)
            R.id.p35 ->
                soundPool.play(e7, 1f, 1f, 0, 0, 1f)


        }
    }

    private fun sounds() {
        c3 = soundPool.load(context, R.raw.c3, 1)
        c3Black = soundPool.load(context, R.raw.c3black, 1)
        e3 = soundPool.load(context, R.raw.e3, 1)
        f3 = soundPool.load(context, R.raw.f3, 1)
        f3Black = soundPool.load(context, R.raw.f3black, 1)
        g3 = soundPool.load(context, R.raw.g3, 1)
        g3Black = soundPool.load(context, R.raw.g3black, 1)
        d3 = soundPool.load(context, R.raw.d3, 1)
        d3Black = soundPool.load(context, R.raw.d3black, 1)
        a3 = soundPool.load(context, R.raw.a3, 1)
        a3Black = soundPool.load(context, R.raw.a3black, 1)
        b3 = soundPool.load(context, R.raw.b3, 1)

        c4 = soundPool.load(context, R.raw.c4, 1)
        c4Black = soundPool.load(context, R.raw.c4black, 1)
        e4 = soundPool.load(context, R.raw.e4, 1)
        f4 = soundPool.load(context, R.raw.f4, 1)
        f4Black = soundPool.load(context, R.raw.f4black, 1)
        g4 = soundPool.load(context, R.raw.g4, 1)
        g4Black = soundPool.load(context, R.raw.g4black, 1)
        d4 = soundPool.load(context, R.raw.d4, 1)
        d4Black = soundPool.load(context, R.raw.d4black, 1)
        a4 = soundPool.load(context, R.raw.a4, 1)
        a4Black = soundPool.load(context, R.raw.a4black, 1)
        b4 = soundPool.load(context, R.raw.b4, 1)

        c5 = soundPool.load(context, R.raw.c5, 1)
        c5Black = soundPool.load(context, R.raw.c5black, 1)
        e5 = soundPool.load(context, R.raw.e5, 1)
        f5 = soundPool.load(context, R.raw.f5, 1)
        f5Black = soundPool.load(context, R.raw.f5black, 1)
        g5 = soundPool.load(context, R.raw.g5, 1)
        g5Black = soundPool.load(context, R.raw.g5black, 1)
        d5 = soundPool.load(context, R.raw.d5, 1)
        d5Black = soundPool.load(context, R.raw.d5black, 1)
        a5 = soundPool.load(context, R.raw.a5, 1)
        a5Black = soundPool.load(context, R.raw.a5black, 1)
        b5 = soundPool.load(context, R.raw.b5, 1)

        c6 = soundPool.load(context, R.raw.c6, 1)
        c6Black = soundPool.load(context, R.raw.c6black, 1);
        e6 = soundPool.load(context, R.raw.e6, 1);
        f6 = soundPool.load(context, R.raw.f6, 1);
        f6Black = soundPool.load(context, R.raw.f6black, 1);
        g6 = soundPool.load(context, R.raw.g6, 1);
        g6Black = soundPool.load(context, R.raw.g6black, 1);
        d6 = soundPool.load(context, R.raw.d6, 1);
        d6Black = soundPool.load(context, R.raw.d6black, 1);
        a6 = soundPool.load(context, R.raw.a6, 1);
        a6Black = soundPool.load(context, R.raw.a6black, 1);
        b6 = soundPool.load(context, R.raw.b6, 1);

        c7 = soundPool.load(context, R.raw.c7, 1);
        c7Black = soundPool.load(context, R.raw.c7black, 1);
        e7 = soundPool.load(context, R.raw.e7, 1);
        f7 = soundPool.load(context, R.raw.f7, 1);
        f7Black = soundPool.load(context, R.raw.f7black, 1);
        g7 = soundPool.load(context, R.raw.g7, 1);
        g7Black = soundPool.load(context, R.raw.g7black, 1);
        d7 = soundPool.load(context, R.raw.d7, 1);
        d7Black = soundPool.load(context, R.raw.d7black, 1);
        a7 = soundPool.load(context, R.raw.a7, 1);
        a7Black = soundPool.load(context, R.raw.a7black, 1);
        b7 = soundPool.load(context, R.raw.b7, 1);

    }



}