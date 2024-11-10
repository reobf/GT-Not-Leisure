package com.science.gtnl.common.item;

import com.science.gtnl.common.GTNLItemList;

import static com.science.gtnl.Utils.TextHandler.texter;
import static com.science.gtnl.common.item.items.ItemAdder01.initItem01;

public class ItemRegister {

        // spotless:off
        public static void registryItemContainers() {
            GTNLItemList.TestItem0.set(initItem01("Test Item 0", 0, new String[]{texter("A test item, no use.", "tooltips.TestItem0.line1")}));
        }

           // spotless:on
        public static void registry() {
            registryItemContainers();
        }
}
