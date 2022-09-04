package ke.kiura.snasa.ui.imageList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ke.kiura.snasa.data.models.Image
import ke.kiura.snasa.databinding.FragmentImageListBinding
import ke.kiura.snasa.network.Resource
import ke.kiura.snasa.ui.imageList.adapter.Callback
import ke.kiura.snasa.ui.imageList.adapter.ImageListAdapter


@AndroidEntryPoint
class ImageListFragment : Fragment(), Callback {
    private lateinit var binding: FragmentImageListBinding
    private val viewModel: ImageListViewModel by viewModels()
    private lateinit var adapter: ImageListAdapter
    private val refresh = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentImageListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = ImageListAdapter(this)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageList.layoutManager = LinearLayoutManager(requireContext())
        binding.imageList.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        subscribeObservers()
    }

    override fun onPause() {
        super.onPause()
        unsubscribeObservers()
    }

    private fun subscribeObservers() {

        viewModel.images.observe(viewLifecycleOwner) { images ->
            when (images) {
                is Resource.Success -> {
                    binding.progressBar.showProgress(false)
                    adapter.updateItems(images.data)
                }
                is Resource.Loading -> {
                    if (!refresh) {
                        binding.progressBar.showProgress(true)
                    }

                }
                is Resource.Failure -> {
                    binding.progressBar.showProgress(false)
                    Toast.makeText(context, images.error, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun unsubscribeObservers() {
        viewModel.images.removeObservers(this)
    }

    override fun imageClicked(image: Image) {
        findNavController().navigate(ImageListFragmentDirections.toImagesList(image))
    }

    /**
     * Use kotlin extensions to extend functionality
     * We extend progress bar as the visibility toggle is used on multiple places
     */
    private fun ProgressBar.showProgress(state: Boolean) {
        visibility = when (state) {
            true -> View.VISIBLE
            false -> View.GONE
        }
    }
}