package com.example.lab_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_2.databinding.FragmentMainBinding
import com.example.lab_2.model.ProgrammingLanguage

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val programmingLanguages = listOf(
            ProgrammingLanguage(
                "Java",
                "General-purpose programming language",
                "Java is a widely used programming language for building enterprise-scale applications.",
                "https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://coursera-course-photos.s3.amazonaws.com/0a/8cd7f1b14344618b75142593bc7af8/JavaCupLogo800x800.png?auto=format%2Ccompress&dpr=1"
            ),
            ProgrammingLanguage(
                "Kotlin",
                "Modern programming language",
                "Kotlin is a statically typed programming language that runs on the Java Virtual Machine (JVM).",
                "https://ih1.redbubble.net/image.1060780989.1021/pp,840x830-pad,1000x1000,f8f8f8.u4.jpg"
            ),
            ProgrammingLanguage(
                "Python",
                "General-purpose programming language",
                "Python is known for its simplicity and readability, making it a popular choice for beginners.",
                "https://www.trio.dev/hubfs/Imported_Blog_Media/python_logo.jpg"
            ),
            ProgrammingLanguage(
                "JavaScript",
                "High-level programming language",
                "JavaScript is primarily used for web development and adding interactivity to websites.",
                "https://learnbatta.com/assets/images/javascript/javascript-logo.png"
            ),
            ProgrammingLanguage(
                "C++",
                "General-purpose programming language",
                "C++ is a powerful language often used for system programming and game development.",
                "https://miro.medium.com/v2/resize:fit:1400/1*oFfl-1UKLtd8XOswpwgriA.png"
            ),
            ProgrammingLanguage(
                "Swift",
                "Programming language for iOS, macOS, and beyond",
                "Swift is designed to work seamlessly with Apple's frameworks and provide a modern syntax.",
                "data:image/png;base64,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"
            )
        )

        val adapter = ProgrammingLanguagesAdapter(programmingLanguages, findNavController())

        binding.recyclerView.adapter = adapter
    }


}
