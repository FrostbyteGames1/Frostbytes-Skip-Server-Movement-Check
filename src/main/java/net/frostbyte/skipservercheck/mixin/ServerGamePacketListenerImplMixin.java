package net.frostbyte.skipservercheck.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Environment(EnvType.SERVER)
@Mixin(value = ServerGamePacketListenerImpl.class, priority = 1001)
public abstract class ServerGamePacketListenerImplMixin {

	@ModifyConstant(method = "handleMovePlayer", constant = @Constant(floatValue = 100.0F))
	private float modifyPlayerMaxSpeed(float speed) {
		return Float.MAX_VALUE;
	}

	@ModifyConstant(method = "handleMovePlayer", constant = @Constant(floatValue = 300.0F))
	private float modifyElytraMaxSpeed(float speed) {
		return Float.MAX_VALUE;
	}

	@ModifyConstant(method = "handleMoveVehicle", constant = @Constant(doubleValue = 100.0))
	private double modifyVehicleMaxSpeed(double speed) {
		return Double.MAX_VALUE;
	}

	@ModifyConstant(method = "handleMovePlayer", constant = @Constant(doubleValue = 0.0625))
	private double modifyPlayerMaxMove(double speed) {
		return Double.MAX_VALUE;
	}

	@ModifyConstant(method = "handleMoveVehicle", constant = @Constant(doubleValue = 0.0625))
	private double modifyVehicleMaxMove(double original) {
		return Double.MAX_VALUE;
	}

}