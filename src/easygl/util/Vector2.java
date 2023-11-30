package easygl.util;



public class Vector2  {

    public float x;
    public float y;

    public static final Vector2 fromTheta(float radians) {
        return new Vector2((float)Math.cos((double)radians), (float)Math.sin((double)radians));
    }

    public Vector2() {
        this.x = this.y = 0.0F;
    }

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2(float[] xy) {
        this.x = xy[0];
        this.y = xy[1];
    }

    public final Vector2 abs() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        return this;
    }

    public final Vector2 add(float x, float y) {
        return new Vector2(this.x + x, this.y + y);
    }

    public Vector2 add(Vector2 vec) {
        return new Vector2(this.x + vec.x, this.y + vec.y);
    }


    public final Vector2 addSelf(float x, float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public final Vector2 addSelf(Vector2 vec) {
        this.x += vec.x;
        this.y += vec.y;
        return this;
    }

    public final float angleBetween(Vector2 vec) {
        return (float)Math.acos((double)this.dot(vec));
    }



    public final Vector2 clear() {
        this.x = this.y = 0.0F;
        return this;
    }



    public final Vector2 copy() {
        return new Vector2(this.x, this.y);
    }

    public float cross(Vector2 vec) {
        return this.x * vec.y - this.y * vec.x;
    }

    public final float distanceTo(Vector2 vec) {
        if (vec != null) {
            float var2 = this.x - vec.x;
            float var3 = this.y - vec.y;
            return (float)Math.sqrt((double)(var2 * var2 + var3 * var3));
        } else {
            return Float.NaN;
        }
    }

    public final float distanceToSquared(Vector2 vec) {
        if (vec != null) {
            float var2 = this.x - vec.x;
            float var3 = this.y - vec.y;
            return var2 * var2 + var3 * var3;
        } else {
            return Float.NaN;
        }
    }

    public final float dot(Vector2 vec) {
        return this.x * vec.x + this.y * vec.y;
    }
    public final float magnitude() {
        return (float)Math.sqrt((double)(this.x * this.x + this.y * this.y));
    }

    public final float magSquared() {
        return this.x * this.x + this.y * this.y;
    }

    public final Vector2 normalize() {
        float var1 = this.x * this.x + this.y * this.y;
        if (var1 > 0.0F) {
            var1 = 1.0F / (float)Math.sqrt((double)var1);
            this.x *= var1;
            this.y *= var1;
        }

        return this;
    }

    public final Vector2 set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }


    public final Vector2 set(Vector2 vec) {
        this.x = vec.x;
        this.y = vec.y;
        return this;
    }


    public final Vector2 sub(float x, float y) {
        return new Vector2(this.x - x, this.y - y);
    }


    public final Vector2 sub(Vector2 vec) {
        return new Vector2(this.x - vec.x, this.y - vec.y);
    }
    public final Vector2 mult(float v) {
        return new Vector2(this.x * v, this.y * v);
    }
    public final Vector2 div(float v) {
        return new Vector2(this.x / v, this.y / v);
    }


    public float[] toArray() {
        return new float[]{this.x, this.y};
    }

    public final Vector2 toCartesian() {
        float var1 = (float)((double)this.x * Math.cos((double)this.y));
        this.y = (float)((double)this.x * Math.sin((double)this.y));
        this.x = var1;
        return this;
    }

    public final Vector2 toPolar() {
        float var1 = (float)Math.sqrt((double)(this.x * this.x + this.y * this.y));
        this.y = (float)Math.atan2((double)this.y, (double)this.x);
        this.x = var1;
        return this;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer(32);
        var1.append("{x:").append(this.x).append(", y:").append(this.y).append("}");
        return var1.toString();
    }
}

