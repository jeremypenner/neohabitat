package org.made.neohabitat.mods;

import org.elkoserver.foundation.json.JSONMethod;
import org.elkoserver.foundation.json.OptInteger;
import org.elkoserver.json.EncodeControl;
import org.elkoserver.json.JSONLiteral;
import org.made.neohabitat.Massive;

/**
 * Habitat Picture Mod
 *
 * Pictures are a Massive which contain a decorative image, rendered
 * client-side.  These are typically used for Region decoration.
 *
 * @author steve
 */
public class Picture extends Massive {

    public int HabitatClass() {
        return CLASS_PICTURE;
    }

    public String HabitatModName() {
        return "Picture";
    }

    public int capacity() {
        return 0;
    }

    public int pc_state_bytes() {
        return 2;
    };

    public boolean known() {
        return true;
    }

    public boolean opaque_container() {
        return false;
    }

    public boolean filler() {
        return false;
    }

    public int picture = 0;

    @JSONMethod({ "style", "x", "y", "orientation", "gr_state", "mass", "picture" })
    public Picture(OptInteger style, OptInteger x, OptInteger y,
        OptInteger orientation, OptInteger gr_state, OptInteger mass,
        OptInteger picture) {
        super(style, x, y, orientation, gr_state, mass);
        this.picture = picture.value(0);
    }

    @Override
    public JSONLiteral encode(EncodeControl control) {
        JSONLiteral result = super.encodeMassive(new JSONLiteral(HabitatModName(), control));
        result.addParameter("picture", picture);
        result.finish();
        return result;
    }

}
