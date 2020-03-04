package org.anas.praassesment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import org.anas.praassesment.databinding.FragmentFragmentPersegiPanjangBinding

/**
 * A simple [Fragment] subclass.
 */
class FragmentPersegiPanjang : Fragment() {

    private var luas = 0
    private var keliling = 0



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentFragmentPersegiPanjangBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_fragment_persegi_panjang, container, false)

        if (savedInstanceState != null){
            keliling = savedInstanceState.getInt("keliling_key",0)
            luas = savedInstanceState.getInt("luas_key",0)
        }

        binding.txtHasilLuas.text = "$luas"
        binding.txtHasilKeliling.text = "$keliling"


        binding.btnHasil.setOnClickListener {

            luas = binding.panjang.text.toString().toInt() * binding.lebar.text.toString().toInt()
            keliling = 2 * (binding.panjang.text.toString().toInt() * binding.lebar.text.toString().toInt())

            binding.txtHasilLuas.text = "$luas"
            binding.txtHasilKeliling.text = "$keliling"
            var args = FragmentPersegiPanjangArgs.fromBundle(arguments!!).contoh

            Toast.makeText(context,"contoh : $args",Toast.LENGTH_LONG).show()
        }



        binding.aboutBtn.setOnClickListener {
            it.findNavController().navigate(FragmentPersegiPanjangDirections.actionFragmentPersegiPanjangToAboutFragment(
                FragmentPersegiPanjangArgs.fromBundle(arguments!!).contoh
            ))
        }



        return binding.root
    }


    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("keliling_key", keliling)
        outState.putInt("luas_key", luas)
        super.onSaveInstanceState(outState)
    }
}
