package com.pujanov69.mariobros.sprites.tileobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.math.Rectangle;
import com.pujanov69.mariobros.MarioBros;
import com.pujanov69.mariobros.scenes.Hud;
import com.pujanov69.mariobros.screens.PlayScreen;
import com.pujanov69.mariobros.sprites.Mario;
import com.pujanov69.mariobros.sprites.tileobjects.InteractiveTileObject;

public class Brick extends InteractiveTileObject {
    public Brick(PlayScreen screen, MapObject object) {

        super(screen, object);
        fixture.setUserData(this);
        setCategoryFilter(MarioBros.BRICK_BIT);
    }

    @Override
    public void onHeadHit(Mario mario) {
        if(mario.isBig()) {
            setCategoryFilter(MarioBros.DESTROYED_BIT);
            getCell().setTile(null);
            Hud.addScore(200);
            MarioBros.manager.get("audio/sounds/breakblock.wav", Sound.class).play();
        }
        MarioBros.manager.get("audio/sounds/bump.wav", Sound.class).play();
    }
}
