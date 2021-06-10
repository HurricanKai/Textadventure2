package de.noahg_kaij.textadventure.user_interface;

/**
 * A scene manager
 * @author Kai Jellinghaus
 */
public interface ISceneManager
{
    /**
     * Changes the current scene
     * @param scene the scene to use
     */
    void changeScene(IScene scene);

    /**
     * Gets the current scene
     * @return the current scene
     */
    IScene getCurrentScene();
}
