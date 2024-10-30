package com.science.gtnl.loader;

import com.science.gtnl.common.block.BlockRegister;
import com.science.gtnl.common.materials.MaterialPool;

import bartworks.API.WerkstoffAdderRegistry;

/**
 * New Material Pool
 * Used Bartworks Werkstoff system
 *
 */
public class MaterialLoader {

    public static void load() {

        BlockRegister.registry();
        WerkstoffAdderRegistry.addWerkstoffAdder(new MaterialPool());

    }

}
