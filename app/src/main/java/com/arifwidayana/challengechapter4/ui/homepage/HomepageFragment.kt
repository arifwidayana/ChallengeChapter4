package com.arifwidayana.challengechapter4.ui.homepage

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.arifwidayana.challengechapter4.R
import com.arifwidayana.challengechapter4.common.base.BaseFragment
import com.arifwidayana.challengechapter4.databinding.FragmentHomepageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomepageFragment : BaseFragment<FragmentHomepageBinding, HomepageViewModel>(
    FragmentHomepageBinding::inflate
) {
    override fun initView() {
        onView()
        onClick()
    }

    private fun onView() {
        viewModelInstance.apply {
            getUser()
            getStocks()
        }
    }

    private fun onClick() {
        binding.apply {
            with(viewModelInstance) {
                ivLogout.setOnClickListener {
                    logoutUser()
                    findNavController().navigate(R.id.action_homepageFragment_to_loginFragment)
                }
            }
        }
    }

    override fun observeData() {
        lifecycleScope.launchWhenStarted {
            viewModelInstance.apply {

            }
        }
    }
    //    private var bind : FragmentHomepageBinding? = null
//    private val binding get() = bind!!
//    private var stocks : StocksDatabase? = null
//    private lateinit var shared : SharedPreference
//    private lateinit var adapter: StocksItemAdapter
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        // Inflate the layout for this fragment
//        bind = FragmentHomepageBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    @SuppressLint("SetTextI18n")
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        shared = SharedPreference(requireContext())
//        adapter = StocksItemAdapter()
//        binding.rvStocks.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
//        binding.rvStocks.adapter = adapter.setData()
//        binding.apply {
//            tvName.text = "Hi ${shared.getString(Constant.USERNAME)}"
//            fabAddStocks.setOnClickListener {
//                AddStocksFragment().show(childFragmentManager, null)
//            }
//            ivLogout.setOnClickListener {
//                shared.clear()
//                Toast.makeText(requireContext(), "Logout Success", Toast.LENGTH_SHORT).show()
//                findNavController().navigate(R.id.action_homepageFragment_to_loginFragment)
//            }
//        }
//        binding.ivRefresh.setOnClickListener {
//            showStocks()
//        }
//    }
//    override fun onResume() {
//        super.onResume()
//        showStocks()
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        bind = null
//    }
//
//    private fun showStocks() {
//
//        adapter.setOnClickCallback(object : StocksItemAdapter.OnItemClickCallback{
//            override fun onItemClicked(dataStocks: StocksEntity) {
//                EditStocksFragment().show(childFragmentManager, null)
//            }
//        })
//    }
}