package minecraftschurli.mfm.util;


public class Reference {
	public static final String MODID = "mfm";
	public static final String NAME = "MFM";
	public static final String MCVERSION = "[1.12.2]";
    public static final String MAJOR_MOD_VERSION = "0";
    public static final String MAJOR_API_VERSION = "0";
    public static final String MINOR_API_MOD_VERSION = "1";
    public static final String PATCH_VERSION = "4";
    public static final String VERSION = MCVERSION.replace("[", "").replace("]", "") + "-" + MAJOR_MOD_VERSION + "." + MAJOR_API_VERSION + "." + MINOR_API_MOD_VERSION + "." + PATCH_VERSION;
	public static final String CLIENTSIDE = "minecraftschurli.mfm.proxy.ClientProxy";
	public static final String SERVERSIDE = "minecraftschurli.mfm.proxy.ServerProxy";
	public static final int GUI_ALLOYING_FURNACE = 0;
	public static final int GUI_STANIUM_SMELTER = 1;
}
