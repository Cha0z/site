package web.site.workfield.leftverticalfield;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.GradientColor;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.shared.ui.colorpicker.Color;
import com.vaadin.ui.*;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;
import web.site.user.UserService;

import java.util.*;

public class ActivityField extends VerticalLayout {

    private UserService service = UserService.getInstance();
    private List<String> timeList;
    //  private TimeChart timeChart = new TimeChart();
    private ComboBox<String> timeBox = new ComboBox<>();
    private ComboBox<String> timeBox2 = new ComboBox<>();
    private Chart chart = new Chart();

    private DataSeries visitor;

    public ActivityField() {
        timeList = Arrays.asList("12 am", "1 am", "2 am", "3 am", "4 am", "5 am", "6 am", "7 am", "8 am", "9 am", "10 am", "11 am"
                , "12 pm", "1 pm", "2 pm", "3 pm", "4 pm", "5 pm", "6 pm", "7 pm", "8 pm", "9 pm", "10 pm", "11 pm");

        configHorizontalField();
        HorizontalLayout recentActivityField = new HorizontalLayout();
        recentActivityField.setWidth("100%");


        VerticalLayout activityMessage = new VerticalLayout();


        Label firstLine = new Label("Recent ActivityField");
        Label secondLine = new Label("number of active users on the systems");
        activityMessage.setMargin(new MarginInfo(true,false));

        activityMessage.addComponents(firstLine, secondLine);

        configActivityMessage(activityMessage, firstLine, secondLine);


        HorizontalLayout timeContainer = new HorizontalLayout();
       // timeContainer.setMargin(new MarginInfo(false, true, false, false));

        Label to = new Label("to");

        timeContainer.addComponents(timeBox, to, timeBox2);
        configTimeBox(timeBox, timeBox2);
        timeBox.setValue(timeList.get(9));
        timeBox2.setValue(timeList.get(18));
        timeBox.addValueChangeListener(e -> updateChart());
        timeBox2.addValueChangeListener(e -> updateChart());


        updateChart();

        chart.getConfiguration().getChart().setBackgroundColor(new SolidColor("#162D34"));


        recentActivityField.addComponents(activityMessage, timeContainer);


        this.addComponents(recentActivityField, chart);
        recentActivityField.setComponentAlignment(timeContainer, Alignment.MIDDLE_RIGHT);
        this.setComponentAlignment(chart, Alignment.MIDDLE_CENTER);


    }

    private void configActivityMessage(VerticalLayout activityMessage, Label firstLine, Label secondLine) {
//        activityMessage.setMargin(new MarginInfo(false, false, false, true));
        activityMessage.setSpacing(false);
        firstLine.setStyleName(ValoTheme.LABEL_COLORED);
        firstLine.setStyleName(ValoTheme.LABEL_LARGE);
        secondLine.setStyleName(ValoTheme.LABEL_LIGHT);
        secondLine.setStyleName(ValoTheme.LABEL_SMALL);
    }

    private void configTimeBox(ComboBox<String> timeBox, ComboBox<String> timeBox2) {
        timeBox.setStyleName(ValoTheme.COMBOBOX_SMALL);
        timeBox.setItems(timeList);
        timeBox.setWidth("7em");
        timeBox2.setItems(timeList);
        timeBox2.setWidth("7em");
        timeBox2.setStyleName(ValoTheme.COMBOBOX_SMALL);
    }

    private void configHorizontalField() {
        this.setSpacing(false);
        this.setMargin(new MarginInfo(false, true));
    }


    private void updateChart() {

        // Configuration conf = chart.getConfiguration();

        Optional<String> time1 = Optional.ofNullable(timeBox.getValue());
        Optional<String> time2 = Optional.ofNullable(timeBox2.getValue());
        Integer timeNumber1 = getTimeNumber(time1);
        Integer timeNumber2 = getTimeNumber(time2);

        Map<Integer, Integer> visitsUnsorted = new TreeMap<>(service.getNumberOfVisitsInHour(timeNumber1, timeNumber2));


        visitor = new DataSeries("Visits");
        for (Map.Entry<Integer, Integer> entry : visitsUnsorted.entrySet()) {
            visitor.add(new DataSeriesItem(entry.getKey(), entry.getValue()));
        }

        Configuration conf = chart.getConfiguration();

        conf.setSeries(visitor);



        chart.drawChart();
        conf.getxAxis().setType(AxisType.CATEGORY);

        PlotOptionsAreaspline line = new PlotOptionsAreaspline();
        line.setColor(new SolidColor("#08BBEE"));
        GradientColor fillColor = GradientColor.createLinear(0, 0, 0, 1);
        fillColor.addColorStop(0, new SolidColor("#bff0ff"));
        fillColor.addColorStop(1, new SolidColor("#08bbee"));
        line.setFillColor(fillColor);
        visitor.setPlotOptions(line);
/*
        PlotOptionsArea plotArea = new PlotOptionsArea();

        plotArea.setFillColor(fillColor);*/



        conf.getTitle().setText(null);
        conf.getLegend().setEnabled(false);
     /*   conf.setPlotOptions(plotArea);*/


    }

    private int getTimeNumber(Optional<String> time) {
        String[] values;
        Integer timeNumber = null;

        if (time.isPresent()) {
            if (time.get().contains("am")) {
                values = time.get().split(" ");
                if (Integer.parseInt(values[0]) == 12) {
                    timeNumber = 0;
                } else timeNumber = Integer.parseInt(values[0]);
            } else {
                values = time.get().split(" ");
                if (Integer.parseInt(values[0]) == 12) {
                    timeNumber = 12;
                } else {
                    timeNumber = 12 + Integer.parseInt(values[0]);
                }
            }

        }
        return timeNumber;
    }
}
