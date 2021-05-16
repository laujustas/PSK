package vu.lt.usecases;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Category;
import vu.lt.entities.Player;
import vu.lt.entities.Team;
import vu.lt.entities.Tool;
import vu.lt.interceptors.LoggedInvocation;
import vu.lt.persistence.CategoryDAO;
import vu.lt.persistence.ToolDAO;

@Model
public class ToolsForCategory implements Serializable {

    @Inject
    private ToolDAO toolDAO;

    @Inject
    private CategoryDAO categoryDAO;

    @Getter @Setter
    private Category category;

    @Getter @Setter
    private Tool toolToCreate = new Tool();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer categoryId = Integer.parseInt(requestParameters.get("categoryId"));
        this.category = categoryDAO.findOne(categoryId);
    }

//    @Transactional
//    public String createTool() {
//        toolToCreate.setCategories(this.category);
//        categoryDAO.persist(toolToCreate);
//        return "/roles?faces-redirect=true&showId=" + this.show.getId();
//    }

//    @Transactional
//    @LoggedInvocation
//    public String createPlayer() {
//        toolToCreate.setCategory(this.tool);
//        playersDAO.persist(playerToCreate);
//        return "players?faces-redirect=true&teamId=" + this.team.getId();
//    }
}
