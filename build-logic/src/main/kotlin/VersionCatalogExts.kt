import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension

internal fun Project.version(key: String) = extensions
    .getByType(VersionCatalogsExtension::class.java)
    .named("libs")
    .findVersion(key)
    .get()
    .requiredVersion

internal fun Project.versionInt(key: String) = version(key).toInt()

internal val Project.ANDROID_APP_VERSION_CODE get() = versionInt("android_app_version_code")
internal val Project.ANDROID_COMPILE_SDK_VERSION get() = versionInt("android_compile_sdk")
internal val Project.ANDROID_MIN_SDK_VERSION get() = versionInt("android_min_sdk")
internal val Project.ANDROID_TARGET_SDK_VERSION get() = versionInt("android_target_sdk")
internal val Project.ANDROID_COMPOSE_COMPILER_VERSION get() = version("android_compose_compiler")
