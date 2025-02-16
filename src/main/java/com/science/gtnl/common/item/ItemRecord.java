package com.science.gtnl.common.item;

import net.minecraft.util.ResourceLocation;

import com.science.gtnl.client.GTNLCreativeTabs;

public class ItemRecord extends net.minecraft.item.ItemRecord {

    public ItemRecord(String recordName) {
        super(recordName);
        setTextureName("sciencenotleisure:Record." + recordName);
        setUnlocalizedName("record");
        setCreativeTab(GTNLCreativeTabs.GTNotLeisureItem);
    }

    @Override
    public ResourceLocation getRecordResource(String name) {
        return new ResourceLocation("sciencenotleisure:" + "record." + recordName);
    }

}
