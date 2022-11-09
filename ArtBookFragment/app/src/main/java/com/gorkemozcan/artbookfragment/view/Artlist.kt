package com.gorkemozcan.artbookfragment.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.gorkemozcan.artbookfragment.R
import com.gorkemozcan.artbookfragment.adapter.ArtListAdapter
import com.gorkemozcan.artbookfragment.databinding.FragmentArtlistBinding
import com.gorkemozcan.artbookfragment.model.Art
import com.gorkemozcan.artbookfragment.roomdb.ArtDao
import com.gorkemozcan.artbookfragment.roomdb.ArtDatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers


class Artlist : Fragment() {

    private lateinit var artAdapter : ArtListAdapter
    private var _binding : FragmentArtlistBinding? = null
    private val binding get() = _binding!!
    private val mDisposable = CompositeDisposable()
    private lateinit var artDao : ArtDao
    private lateinit var artDatabase : ArtDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        artDatabase = Room.databaseBuilder(requireContext(), ArtDatabase::class.java, "Arts").build()
        artDao = artDatabase.artDao()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArtlistBinding.inflate(layoutInflater, container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getFromSQL()
    }


    fun getFromSQL()
    {
        mDisposable.add(artDao.getArtWithNameAndId()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResponse))

    }

    private fun handleResponse(artList: List<Art>){
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        artAdapter = ArtListAdapter(artList)
        binding.recyclerView.adapter = artAdapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}