package io.wms.ib.domain.model.vo;

import io.wms.ib.domain.model.ShelvingTaskCreator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShelvingTaskItemDelegateTest {

    @Test
    public void testCreateWith() throws Exception {
        ShelvingTaskCreator creator = new ShelvingTaskCreator();
        ShelvingTaskCreator.Item item = new ShelvingTaskCreator.Item();
        item.setSku("23233");
        List<ShelvingTaskCreator.Item> items = new ArrayList<>();
        items.add(item);
        creator.setItems(items);

        ShelvingTaskItemDelegate delegate = ShelvingTaskItemDelegate.createWith(creator);
        assertEquals(1, delegate.size());
    }
}