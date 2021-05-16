package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Category;
import vu.lt.entities.Tool;
import vu.lt.persistence.ToolDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Tools {

    @Inject
    private ToolDAO toolDAO;

    @Getter @Setter
    private Tool toolToCreate = new Tool();

    @Getter
    private List<Tool> allTools;

    @PostConstruct
    public void init(){
        loadAllTools();
    }

    @Transactional
    public String createTool(){
        this.toolDAO.persist(toolToCreate);
        return "index?faces-redirect=true";
    }

    @Transactional
    public String deleteTool(Tool toolToDelete){
        this.toolDAO.delete(toolToDelete);
        return "index?faces-redirect=true";
    }

    private void loadAllTools(){
        this.allTools = toolDAO.loadAll();
    }
}
