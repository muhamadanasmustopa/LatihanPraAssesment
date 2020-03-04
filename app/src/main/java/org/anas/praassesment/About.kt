package org.anas.praassesment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast


/**
 * A simple [Fragment] subclass.
 */
class About : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var args = AboutArgs.fromBundle(arguments!!)
        Toast.makeText(context, "Contoh : ${args.contoh}", Toast.LENGTH_LONG).show()
        return inflater.inflate(R.layout.fragment_about, container, false)

    }


}
