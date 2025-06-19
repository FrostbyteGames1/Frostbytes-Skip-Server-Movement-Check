package net.frostbyte.skipservercheck.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

@Environment(EnvType.SERVER)
@Mixin(value = ServerPlayNetworkHandler.class, priority = 1001)
public abstract class ServerPlayNetworkHandlerMixin {
	@Redirect(method = "onPlayerMove", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/Vec3d;lengthSquared()D", ordinal = 0))
	public double preLengthSquared(Vec3d instance) {
		return Float.MAX_VALUE;
	}

	@Redirect(method = "onVehicleMove", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/Vec3d;lengthSquared()D", ordinal = 0))
	public double preVehicleLengthSquared(Vec3d instance) {
		return Float.MAX_VALUE;
	}

	@ModifyConstant(method = "onPlayerMove", constant = @Constant(doubleValue = 0.0625))
	private double modifyPlayerMoveDoubleConst(double original) {
		return Float.MAX_VALUE;
	}

	@ModifyConstant(method = "onVehicleMove", constant = @Constant(doubleValue = 0.0625, ordinal = 1))
	private double modifyVehicleMoveDoubleConst(double original) {
		return Float.MAX_VALUE;
	}
}