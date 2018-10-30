package io.particle.mesh.setup.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.particle.android.sdk.cloud.ParticleCloudSDK
import io.particle.android.sdk.cloud.ParticleEventVisibility
import io.particle.sdk.app.R
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import java.util.concurrent.TimeUnit


class LetsGetBuildingFragment : BaseMeshSetupFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        launch {
            ParticleCloudSDK.getCloud().publishEvent(
                "mesh-setup-session-complete",
                null,
                ParticleEventVisibility.PRIVATE,
                TimeUnit.HOURS.toSeconds(1).toInt()
            )
        }

        return inflater.inflate(R.layout.fragment_lets_get_building, container, false)
    }


}
