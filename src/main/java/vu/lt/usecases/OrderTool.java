package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Tool;
import vu.lt.persistence.ToolDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Map;

@Model
public class OrderTool implements Serializable {
    @Inject
    private ToolDAO toolDAO;

    @Getter @Setter
    private Tool tool;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer toolId = Integer.parseInt(requestParameters.get("toolId"));
        System.out.println(toolId);
        this.tool = toolDAO.findOne(toolId);
    }
}
