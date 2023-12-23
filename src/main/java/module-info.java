module com.example.layeredarchitecture {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.sql;

    opens lk.jl.layeredarchitecture to javafx.fxml;
    opens lk.jl.layeredarchitecture.controller to javafx.fxml;
    opens lk.jl.layeredarchitecture.view.tdm to javafx.base;

    exports lk.jl.layeredarchitecture;
    exports lk.jl.layeredarchitecture.controller;
}
