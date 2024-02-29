package com.brunoca.timezone.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "myzones")
public class MyZone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String zone;

    public MyZone() {
    }

    public MyZone(Long id, String zone) {
        this.id = id;
        this.zone = zone;
    }

    public Long getId() {
        return this.id;
    }

    public String getZone() {
        return this.zone;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MyZone)) return false;
        final MyZone other = (MyZone) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$zone = this.getZone();
        final Object other$zone = other.getZone();
        if (this$zone == null ? other$zone != null : !this$zone.equals(other$zone)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MyZone;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $zone = this.getZone();
        result = result * PRIME + ($zone == null ? 43 : $zone.hashCode());
        return result;
    }

    public String toString() {
        return "MyZone(id=" + this.getId() + ", zone=" + this.getZone() + ")";
    }
}
