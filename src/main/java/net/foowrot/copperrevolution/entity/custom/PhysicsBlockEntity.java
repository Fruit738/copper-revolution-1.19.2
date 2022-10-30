package net.foowrot.copperrevolution.entity.custom;

import dev.lazurite.rayon.api.EntityPhysicsElement;
import dev.lazurite.rayon.impl.bullet.collision.body.EntityRigidBody;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.util.Arm;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Optional;


public class PhysicsBlockEntity extends LivingEntity implements EntityPhysicsElement
{

    private static final TrackedData<Optional<BlockState>> BLOCK_STATE = DataTracker.registerData(PhysicsBlockEntity.class, TrackedDataHandlerRegistry.OPTIONAL_BLOCK_STATE);
    private static final TrackedData<BlockPos> BLOCK_POS = DataTracker.registerData(PhysicsBlockEntity.class, TrackedDataHandlerRegistry.BLOCK_POS);
    private final EntityRigidBody rigidBody = new EntityRigidBody(this);


    public PhysicsBlockEntity(EntityType<? extends LivingEntity> type, World world) {
        super(type, world);

        this.rigidBody.setDragCoefficient(0.001f);
        this.rigidBody.setMass(50.0f);
    }


    //public PhysicsBlockEntity(World world, double x, double y, double z, BlockState blockState) {
    //this(ModEntities.PHYSICS_BLOCK_ENTITY, world);
    //    this.updatePosition(x, y, z);
    //    this.setBlockState(blockState);
    //    this.setFallingBlockPos(new BlockPos(x, y, z));
    //}


    @Override
    protected void initDataTracker() {

    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {

    }

    @Override
    public Iterable<ItemStack> getArmorItems() {
        return null;
    }

    @Override
    public ItemStack getEquippedStack(EquipmentSlot slot) {
        return null;
    }

    @Override
    public void equipStack(EquipmentSlot slot, ItemStack stack) {

    }

    @Override
    public Arm getMainArm() {
        return null;
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {

    }

    @Override
    public Packet<?> createSpawnPacket() {
        return null;
    }



    @Override
    public EntityRigidBody getRigidBody() {
        return null;
    }

    @Override
    protected void fall(double d, boolean bl, BlockState blockState, BlockPos blockPos) {

    }

    public BlockState getBlockState() {
        return getDataTracker().get(BLOCK_STATE).orElse(null);
    }

    public void setBlockState(BlockState blockState) {
        getDataTracker().set(BLOCK_STATE, Optional.ofNullable(blockState));
    }

    public BlockPos getFallingBlockPos() {
        return getDataTracker().get(BLOCK_POS);
    }

    public void setFallingBlockPos(BlockPos blockPos) {
        getDataTracker().set(BLOCK_POS, blockPos);
    }
}
