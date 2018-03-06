package minecraftschurli.mfm.util.handlers;

import net.minecraft.util.IStringSerializable;

public class EnumHandler 
{
    public enum EnumType implements IStringSerializable
	{
		CRYSTAL(0, "crystal"),
		STANIUM(1, "stanium"),
		KANDIUM(2, "kandium"), 
		VULCANIUM(3, "vulcanium");
		
		private static final EnumType[] META_LOOKUP = new EnumType[values().length];
		private final int meta;
		private final String name, unlocializedName;

        EnumType(int meta, String name)
		{
			this(meta, name, name);
		}

        EnumType(int meta, String name, String unlocializedName)
		{
			this.meta = meta;
			this.name = name;
			this.unlocializedName = unlocializedName;
		}
		
		@Override
		public String getName() 
		{
			return this.name;
		}
		
		public int getMeta() 
		{
			return this.meta;
		}
		
		public String getUnlocializedName() 
		{
			return this.unlocializedName;
		}
		
		@Override
		public String toString() 
		{
			return this.name;
		}
		
		public static EnumType byMetadata(int meta)
		{
			return META_LOOKUP[meta];
		}
		
		static
		{
			for(EnumType enumtype : values())
			{
				META_LOOKUP[enumtype.getMeta()] = enumtype;
			}
		}
	}
}
