package skynetbee.developers.developerenvironment

import android.content.Context
import android.util.Log

/**
 * Main entry point for the SkynetBee Developer Environment Library
 * This class provides initialization and core functionality access
 */
object EngineStarter {
    
    private var isInitialized = false
    private lateinit var applicationContext: Context
    
    /**
     * Initialize the SkynetBee Developer Environment Library
     * Call this once in your Application class or MainActivity
     * 
     * @param context Application or Activity context
     */
    fun initialize(context: Context) {
        if (isInitialized) {
            Log.w("EngineStarter", "Library already initialized")
            return
        }
        
        applicationContext = context.applicationContext
        isInitialized = true
        
        Log.i("EngineStarter", "SkynetBee Developer Environment Library initialized successfully")
        Log.i("EngineStarter", "Version: 1.0.1")
        Log.i("EngineStarter", "Ready to use all components!")
    }
    
    /**
     * Check if the library is initialized
     * @return true if initialized, false otherwise
     */
    fun isInitialized(): Boolean = isInitialized
    
    /**
     * Get the application context
     * @return Application context if initialized
     * @throws IllegalStateException if not initialized
     */
    fun getContext(): Context {
        if (!isInitialized) {
            throw IllegalStateException("EngineStarter not initialized. Call initialize() first.")
        }
        return applicationContext
    }
    
    /**
     * Get library version information
     * @return Version string
     */
    fun getVersion(): String = "1.0.1"
    
    /**
     * Get library build information
     * @return Build info string
     */
    fun getBuildInfo(): String = "SkynetBee Developer Environment Library v1.0.1 - Built for Android"
}
