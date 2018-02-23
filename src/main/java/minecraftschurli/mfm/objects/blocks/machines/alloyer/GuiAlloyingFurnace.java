package minecraftschurli.mfm.objects.blocks.machines.alloyer;

import minecraftschurli.mfm.util.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiAlloyingFurnace extends GuiContainer {
	
	private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/gui/alloying_furnace.png");
	private final InventoryPlayer player;
	private final TileEntityAlloyingFurnace tileentity;
	
	public GuiAlloyingFurnace(InventoryPlayer player,TileEntityAlloyingFurnace tileentity) {
		super(new ContainerAlloyingFurnace(player, tileentity));
		this.player = player;
		this.tileentity = tileentity;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String tileName = this.tileentity.getDisplayName().getUnformattedText();
		this.fontRenderer.drawString(tileName, (this.xSize / 2 - this.fontRenderer.getStringWidth(tileName) / 2), 4, 4210752);
		this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(TEXTURES);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		if(TileEntityAlloyingFurnace.isActive(tileentity)){
			int k = this.getBurnLeftScaled(13);
			this.drawTexturedModalRect(this.guiLeft + 45, this.guiTop + 37 + 12 - k, 176, 12 - k, 14, k + 1);
		}
		
		int l = this.getCookProgressScaled(24);
		this.drawTexturedModalRect(this.guiLeft + 80, this.guiTop + 35, 176, 14, l + 1, 16);
	}
	
	private int getBurnLeftScaled(int pixels)
	{
		int i = this.tileentity.getField(1);
		if(i == 0) i = 200;
		return this.tileentity.getField(0) * pixels / i;
	}
	
	private int getCookProgressScaled(int pixels)
	{
		int i = this.tileentity.getField(2);
		int j = this.tileentity.getField(3);
		return j != 0 && i != 0 ? i * pixels / j : 0;
	}

}
