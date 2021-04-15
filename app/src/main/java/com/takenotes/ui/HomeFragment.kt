package com.takenotes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.takenotes.R
import com.takenotes.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(), View.OnClickListener{

    private var _binding: FragmentHomeBinding? =null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.floatingActionButton.setOnClickListener(this)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment()
    }

    override fun onClick(v: View?) {
        if (v != null && _binding != null) {
            if (v == binding.floatingActionButton) {
                val action =
                    HomeFragmentDirections
                        .actionHomeFragmentToCreateNoteFragment()
                Toast.makeText(requireContext(),"Clicked on FAB",Toast.LENGTH_SHORT).show()
                v.findNavController().navigate(action)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}