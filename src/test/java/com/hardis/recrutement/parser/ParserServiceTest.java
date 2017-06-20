package com.hardis.recrutement.parser;

import com.hardis.recrutement.model.ParserOutputData;
import com.hardis.recrutement.parser.impl.ParserServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * User: MELGADI
 * Date: 20/06/2017
 */
@RunWith(MockitoJUnitRunner.class)
public class ParserServiceTest {

    final File ERROR1_FILE = new File(this.getClass().getClassLoader().getResource("file_error1.csv").getFile());
    final File ERROR2_FILE = new File(this.getClass().getClassLoader().getResource("file_error2.csv").getFile());
    final File ERROR3_FILE = new File(this.getClass().getClassLoader().getResource("file_error3.csv").getFile());
    final File ERROR4_FILE = new File(this.getClass().getClassLoader().getResource("file_error4.csv").getFile());
    final File CORRECT1_FILE = new File(this.getClass().getClassLoader().getResource("file1.csv").getFile());

    @InjectMocks
    ParserServiceImpl parserService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testParseFile_shouldReturnNoError_whenDataAreCorrect() throws UnsupportedEncodingException, FileNotFoundException {
        ParserOutputData outout = parserService.parseFile(CORRECT1_FILE.getAbsolutePath());
        Assert.assertNotNull(outout);
        Assert.assertEquals("file1.csv", outout.getInputFile());
        Assert.assertTrue(CollectionUtils.isEmpty(outout.getErrors()));
        Assert.assertTrue(CollectionUtils.isNotEmpty(outout.getReferences()));
    }

    @Test
    public void testParseFile_shouldReturnError_whenColorIsNotCorrect() throws UnsupportedEncodingException, FileNotFoundException {
        ParserOutputData outout = parserService.parseFile(ERROR1_FILE.getAbsolutePath());
        Assert.assertNotNull(outout);
        Assert.assertEquals("file_error1.csv", outout.getInputFile());
        Assert.assertEquals(1, outout.getErrors().size());
        Assert.assertEquals("A", outout.getErrors().get(0).getValue());
        Assert.assertEquals("Incorrect value of color", outout.getErrors().get(0).getMessage());
        Assert.assertEquals(4, outout.getReferences().size());
    }

    @Test
    public void testParseFile_shouldReturnError_whenPriceIsNotCorrect() throws UnsupportedEncodingException, FileNotFoundException {
        ParserOutputData outout = parserService.parseFile(ERROR2_FILE.getAbsolutePath());
        Assert.assertNotNull(outout);
        Assert.assertEquals("file_error2.csv", outout.getInputFile());
        Assert.assertEquals(1, outout.getErrors().size());
        Assert.assertEquals("err_price", outout.getErrors().get(0).getValue());
        Assert.assertEquals("Incorrect value of price", outout.getErrors().get(0).getMessage());
        Assert.assertEquals(4, outout.getReferences().size());
    }


    @Test
    public void testParseFile_shouldReturnError_whenReferenceNumIsNotCorrect() throws UnsupportedEncodingException, FileNotFoundException {
        ParserOutputData outout = parserService.parseFile(ERROR3_FILE.getAbsolutePath());
        Assert.assertNotNull(outout);
        Assert.assertEquals("file_error3.csv", outout.getInputFile());
        Assert.assertEquals(1, outout.getErrors().size());
        Assert.assertEquals("14621004", outout.getErrors().get(0).getValue());
        Assert.assertEquals("Incorrect value of reference number", outout.getErrors().get(0).getMessage());
        Assert.assertEquals(4, outout.getReferences().size());
    }


    @Test
    public void testParseFile_shouldReturnError_whenSizeIsNotCorrect() throws UnsupportedEncodingException, FileNotFoundException {
        ParserOutputData outout = parserService.parseFile(ERROR4_FILE.getAbsolutePath());
        Assert.assertNotNull(outout);
        Assert.assertEquals("file_error4.csv", outout.getInputFile());
        Assert.assertEquals(1, outout.getErrors().size());
        Assert.assertEquals("size", outout.getErrors().get(0).getValue());
        Assert.assertEquals("Incorrect value of size", outout.getErrors().get(0).getMessage());
        Assert.assertEquals(4, outout.getReferences().size());
    }


}
