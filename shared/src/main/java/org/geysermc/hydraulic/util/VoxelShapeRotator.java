package org.geysermc.hydraulic.util;

import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VoxelShapeRotator {
    // Method to rotate a VoxelShape by the specified rotation angles
    public static VoxelShape rotateVoxelShapeByAngles(VoxelShape shape, int rotationX, int rotationY, int rotationZ) {
        VoxelShape[] rotatedShape = { shape };

        // Iterate over the VoxelShape and apply rotation to each box
        shape.forAllBoxes((x1, y1, z1, x2, y2, z2) -> {
            // Apply rotation to the bounding box coordinates
            int[] rotatedCoordinates = rotateBoundingBox(x1, y1, z1, x2, y2, z2, rotationX, rotationY, rotationZ);
            
            // Create a new shape from the rotated bounding box and join it with the current shape
            rotatedShape[0] = Shapes.joinUnoptimized(rotatedShape[0], Shapes.box(
                    rotatedCoordinates[0], rotatedCoordinates[1], rotatedCoordinates[2],
                    rotatedCoordinates[3], rotatedCoordinates[4], rotatedCoordinates[5]
            ), BooleanOp.OR);
        });

        return rotatedShape[0];
    }

    // Method to rotate the coordinates of a bounding box
    private static int[] rotateBoundingBox(double x1, double y1, double z1, double x2, double y2, double z2, int rotationX, int rotationY, int rotationZ) {
        int[] rotated = {(int) x1, (int) y1, (int) z1, (int) x2, (int) y2, (int) z2};

        // Rotate around the X-axis
        if (rotationX == 90) {
            rotated[1] = (int) z2;
            rotated[2] = (int) -y2;
            rotated[4] = (int) z1;
            rotated[5] = (int) -y1;
        } else if (rotationX == 180) {
            rotated[1] = (int) -y2;
            rotated[2] = (int) -z2;
            rotated[4] = (int) -y1;
            rotated[5] = (int) -z1;
        } else if (rotationX == 270) {
            rotated[1] = (int) -z1;
            rotated[2] = (int) y2;
            rotated[4] = (int) -z2;
            rotated[5] = (int) y1;
        }

        // Rotate around the Y-axis
        if (rotationY == 90) {
            int temp = rotated[0];
            rotated[0] = rotated[2];
            rotated[2] = -temp;
            temp = rotated[3];
            rotated[3] = rotated[5];
            rotated[5] = -temp;
        } else if (rotationY == 180) {
            rotated[0] = -rotated[0];
            rotated[2] = -rotated[2];
            rotated[3] = -rotated[3];
            rotated[5] = -rotated[5];
        } else if (rotationY == 270) {
            int temp = rotated[0];
            rotated[0] = -rotated[2];
            rotated[2] = rotated[3];
            rotated[3] = -rotated[5];
            rotated[5] = -temp;
        }

        // Rotate around the Z-axis
        if (rotationZ == 90) {
            int temp = rotated[0];
            rotated[0] = rotated[1];
            rotated[1] = -temp;
            temp = rotated[3];
            rotated[3] = rotated[4];
            rotated[4] = -temp;
        } else if (rotationZ == 180) {
            rotated[0] = -rotated[0];
            rotated[1] = -rotated[1];
            rotated[3] = -rotated[3];
            rotated[4] = -rotated[4];
        } else if (rotationZ == 270) {
            int temp = rotated[0];
            rotated[0] = -rotated[1];
            rotated[1] = temp;
            temp = rotated[3];
            rotated[3] = -rotated[4];
            rotated[4] = temp;
        }

        return rotated;
    }
}