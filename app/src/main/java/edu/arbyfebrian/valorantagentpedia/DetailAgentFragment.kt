
package edu.arbyfebrian.valorantagentpedia
import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import edu.arbyfebrian.valorantagentpedia.models.Agent

class DetailAgentFragment : Fragment() {

    companion object {
        const val EXTRA_AGENT = "extra_agent"

        fun newInstance(agent: Agent): DetailAgentFragment {
            val fragment = DetailAgentFragment()
            val args = Bundle()
            args.putSerializable(EXTRA_AGENT, agent)
            fragment.arguments = args
            return fragment
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_detail_agent, container, false)

        val agent = arguments?.getSerializable(EXTRA_AGENT) as? Agent
        if (agent != null) {
            val imageViewIcon: ImageView = rootView.findViewById(R.id.imageViewIcon)
            val textViewName: TextView = rootView.findViewById(R.id.textViewName)
            val textViewNameDesc: TextView = rootView.findViewById(R.id.textViewNameDesc)
            val imageViewRole: ImageView = rootView.findViewById(R.id.imageViewRole)
            val imageViewRole2: ImageView = rootView.findViewById(R.id.imageViewRole2)
            val textViewRole: TextView = rootView.findViewById(R.id.textViewRole)
            val textViewRoleDesc: TextView = rootView.findViewById(R.id.textViewRoleDesc)
            val imageViewSkill1Icon: ImageView = rootView.findViewById(R.id.imageViewSkill1Icon)
            val textViewSkill1: TextView = rootView.findViewById(R.id.textViewSkill1Name)
            val textViewSkill1Desc: TextView = rootView.findViewById(R.id.textViewSkill1Desc)
            val imageViewSkill2Icon: ImageView = rootView.findViewById(R.id.imageViewSkill2Icon)
            val textViewSkill2: TextView = rootView.findViewById(R.id.textViewSkill2Name)
            val textViewSkill2Desc: TextView = rootView.findViewById(R.id.textViewSkill2Desc)
            val imageViewSkill3Icon: ImageView = rootView.findViewById(R.id.imageViewSkill3Icon)
            val textViewSkill3: TextView = rootView.findViewById(R.id.textViewSkill3Name)
            val textViewSkill3Desc: TextView = rootView.findViewById(R.id.textViewSkill3Desc)
            val imageViewSkill4Icon: ImageView = rootView.findViewById(R.id.imageViewSkill4Icon)
            val textViewSkill4: TextView = rootView.findViewById(R.id.textViewSkill4Name)
            val textViewSkill4Desc: TextView = rootView.findViewById(R.id.textViewSkill4Desc)
            val imageViewBackgroundAgent: ImageView = rootView.findViewById(R.id.imageViewBackgroundAgent)


            //Agent Profile
            textViewName.text = "Agent "+agent.displayName
            textViewNameDesc.text = agent.description
            textViewRole.text = "Role "+agent.role.displayName
            textViewRoleDesc.text = agent.role.description


            Glide.with(requireContext())
                .load(agent.fullPortrait)
                .into(imageViewIcon)

            Glide.with(requireContext())
                .load(agent.background)
                .into(imageViewBackgroundAgent)

            Glide.with(requireContext())
                .load(agent.role.displayIcon)
                .into(imageViewRole)
            Glide.with(requireContext())
                .load(agent.role.displayIcon)
                .into(imageViewRole2)


            //Skill 1
            textViewSkill1.text = agent.abilities[0].displayName
            textViewSkill1Desc.text = agent.abilities[0].description
            Glide.with(requireContext())
                .load(agent.abilities[0].displayIcon)
                .into(imageViewSkill1Icon)

            //Skill 2
            textViewSkill2.text = agent.abilities[1].displayName
            textViewSkill2Desc.text = agent.abilities[1].description
            Glide.with(requireContext())
                .load(agent.abilities[1].displayIcon)
                .into(imageViewSkill2Icon)

            //Skill 3
            textViewSkill3.text = agent.abilities[2].displayName
            textViewSkill3Desc.text = agent.abilities[2].description
            Glide.with(requireContext())
                .load(agent.abilities[2].displayIcon)
                .into(imageViewSkill3Icon)

            //Skill 4
            textViewSkill4.text = agent.abilities[3].displayName
            textViewSkill4Desc.text = agent.abilities[3].description
            Glide.with(requireContext())
                .load(agent.abilities[3].displayIcon)
                .into(imageViewSkill4Icon)

        } else {
            // Handle the case when the agent is null
        }

        return rootView
    }
}
