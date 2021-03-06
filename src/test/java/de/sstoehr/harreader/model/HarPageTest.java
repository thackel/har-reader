package de.sstoehr.harreader.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class HarPageTest extends AbstractMapperTest<HarPage> {

    private final static Date EXPECTED_STARTED = new Date() {{
        setTime(1388577600000L);
    }};

    @Override
    public void testMapping() {
        HarPage page = map("{\"startedDateTime\":\"2014-01-01T12:00:00\",\"id\":\"anId\","
        + "\"title\":\"aTitle\",\"pageTimings\":{},\"comment\":\"my comment\"}", HarPage.class);

        Assert.assertNotNull(page);
        Assert.assertEquals(EXPECTED_STARTED, page.getStartedDateTime());
        Assert.assertEquals("anId", page.getId());
        Assert.assertEquals("aTitle", page.getTitle());
        Assert.assertNotNull(page.getPageTimings());
        Assert.assertEquals("my comment", page.getComment());

        page = map(UNKNOWN_PROPERTY, HarPage.class);
        Assert.assertNotNull(page);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStartedDateTimeNull() {
        HarPage page = new HarPage();
        page.setStartedDateTime(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIdNull() {
        HarPage page = new HarPage();
        page.setId(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTitleNull() {
        HarPage page = new HarPage();
        page.setTitle(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPageTimingsNull() {
        HarPage page = new HarPage();
        page.setPageTimings(null);
    }
}
