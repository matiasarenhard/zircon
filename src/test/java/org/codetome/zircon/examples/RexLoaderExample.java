package org.codetome.zircon.examples;

import org.codetome.zircon.api.resource.REXPaintResource;
import org.codetome.zircon.api.Size;
import org.codetome.zircon.api.builder.TerminalBuilder;
import org.codetome.zircon.api.graphics.Layer;
import org.codetome.zircon.api.resource.PhysicalFontResource;
import org.codetome.zircon.api.screen.Screen;

import java.io.InputStream;
import java.util.List;

public class RexLoaderExample {
    private static final int TERMINAL_WIDTH = 40;
    private static final int TERMINAL_HEIGHT = 23;
    private static final InputStream RESOURCE = RexLoaderExample.class.getResourceAsStream("/rex_files/xptest.xp");

    public static void main(String[] args) {
        REXPaintResource rex = REXPaintResource.loadREXFile(RESOURCE);

        final Screen screen = TerminalBuilder.newBuilder()
                .font(PhysicalFontResource.UBUNTU_MONO.toFont())
                .initialTerminalSize(Size.of(TERMINAL_WIDTH, TERMINAL_HEIGHT))
                .buildScreen();
        screen.setCursorVisible(false);
        List<Layer> layers = rex.toLayerList();
        for (Layer layer: layers) {
            screen.addLayer(layer);
        }
        screen.display();
    }
}