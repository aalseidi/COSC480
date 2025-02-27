module edu.emu.netmonitoring {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens edu.emu.netmonitoring to javafx.fxml;
    exports edu.emu.netmonitoring;
    exports edu.emu.netmonitoring.controller;
    opens edu.emu.netmonitoring.controller to javafx.fxml;
}