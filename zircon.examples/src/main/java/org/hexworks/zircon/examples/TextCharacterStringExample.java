package org.hexworks.zircon.examples;

import org.hexworks.zircon.api.*;
import org.hexworks.zircon.api.application.Application;
import org.hexworks.zircon.api.color.ANSITileColor;
import org.hexworks.zircon.api.data.Size;
import org.hexworks.zircon.api.graphics.CharacterTileString;
import org.hexworks.zircon.api.grid.TileGrid;
import org.hexworks.zircon.api.resource.BuiltInCP437TilesetResource;

public class TextCharacterStringExample {

    private static final int TERMINAL_WIDTH = 42;
    private static final int TERMINAL_HEIGHT = 16;
    private static final Size SIZE = Sizes.create(TERMINAL_WIDTH, TERMINAL_HEIGHT);

    public static void main(String[] args) {
        Application app = SwingApplications.startApplication(AppConfigs.newConfig()
                .withDefaultTileset(BuiltInCP437TilesetResource.TAFFER_20X20)
                .withSize(SIZE)
                .withDebugMode(true)
                .build());

        TileGrid tileGrid = app.getTileGrid();

        CharacterTileString tcs = CharacterTileStrings.newBuilder()
                .withForegroundColor(TileColors.fromString("#eeffee"))
                .withBackgroundColor(TileColors.fromString("#223344"))
                .withModifiers(Modifiers.underline())
                .withText("This is some text which is too long to fit on one line...")
                .build();

        tileGrid.draw(tcs, Positions.zero());

    }

    private static void putEmptySpace(TileGrid tileGrid) {
        tileGrid.resetColorsAndModifiers();
        tileGrid.setForegroundColor(ANSITileColor.BLACK);
        tileGrid.putCharacter(' ');
    }

}
