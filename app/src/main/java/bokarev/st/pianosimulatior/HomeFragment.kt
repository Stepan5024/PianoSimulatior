package bokarev.st.pianosimulatior

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(), CellClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    override fun onCellClickListener() {
        Toast.makeText(context,"Cell clicked", Toast.LENGTH_SHORT).show()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        val text_record: TextView = view.findViewById(R.id.text_toolkit_navigation_record)
        text_record.setOnClickListener {
            val pianoModeFragment = PianoModeFragment()
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout, pianoModeFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
        }
        val text_learn: TextView = view.findViewById(R.id.text_teach)
        text_learn.setOnClickListener {
            val quizeNoteFragment = QuizeNoteFragment()
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout, quizeNoteFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
        }


// используем адаптер данных
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = Adapter(requireContext(), fetchList(), this)

        return view
    }

    private fun getCatList(): List<String> {
        return this.resources.getStringArray(R.array.cat_names).toList()
    }

    private fun fetchList(): ArrayList<Model> {
        val list = arrayListOf<Model>()

        for (i in 0..9) {
            val model = Model(R.drawable.home_fill_light, "Title : $i", "Subtitle : $i")
            list.add(model)
        }
        return list
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}