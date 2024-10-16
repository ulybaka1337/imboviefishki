package ru.ulybaka1337.modules;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.gui.screen.ChatScreen;
import thunder.hack.features.modules.Module;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.client.gui.screen.Screen;
import thunder.hack.gui.clickui.ClickGUI;
import thunder.hack.setting.Setting;

import static thunder.hack.features.modules.client.ClientSettings.isRu;

public class CloseGUIWIthoutPacket extends Module {

    public Setting<Boolean> clearSavedAfterOpen = new Setting<>("ClearSavedAfterOpen", false, v -> true);

    public Screen screen;
    public ScreenHandler screenHandler;

    public CloseGUIWIthoutPacket() {
        super("CloseGUIWithoutPacket", Category.getCategory("Imboviefishki"));
    }

    @Override
    public void onEnable() {
        if (mc.currentScreen == null || mc.currentScreen instanceof ChatScreen || mc.currentScreen instanceof ClickGUI) {
            disable(isRu() ? "Гуй не открыт!" : "GUI isnt open!");
            return;
        }

        screen = mc.currentScreen;
        screenHandler = mc.player.currentScreenHandler;
        mc.setScreen(null);
        sendMessage(isRu() ? "Интерфейс сохранен! Выключи модуль чтобы открыть" : "GUI have been saved! Disable module to open.");
    }

    @Override
    public void onDisable() {
        if (screen != null) {
            mc.setScreen(screen);
            mc.player.currentScreenHandler = screenHandler;

            sendMessage(isRu() ? "Интерфейс открыт." : "GUI Opened.");

            if (!clearSavedAfterOpen.getValue()) return;

            screen = null;
            screenHandler = null;

        }
    }
}
