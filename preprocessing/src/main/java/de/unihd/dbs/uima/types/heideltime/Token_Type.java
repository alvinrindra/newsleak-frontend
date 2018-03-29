
/* First created by JCasGen Thu Nov 23 16:42:40 CET 2017 */
package de.unihd.dbs.uima.types.heideltime;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Thu Mar 22 16:33:35 CET 2018
 * @generated */
public class Token_Type extends Annotation_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Token.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.unihd.dbs.uima.types.heideltime.Token");
 
  /** @generated */
  final Feature casFeat_filename;
  /** @generated */
  final int     casFeatCode_filename;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getFilename(int addr) {
        if (featOkTst && casFeat_filename == null)
      jcas.throwFeatMissing("filename", "de.unihd.dbs.uima.types.heideltime.Token");
    return ll_cas.ll_getStringValue(addr, casFeatCode_filename);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setFilename(int addr, String v) {
        if (featOkTst && casFeat_filename == null)
      jcas.throwFeatMissing("filename", "de.unihd.dbs.uima.types.heideltime.Token");
    ll_cas.ll_setStringValue(addr, casFeatCode_filename, v);}
    
  
 
  /** @generated */
  final Feature casFeat_tokenId;
  /** @generated */
  final int     casFeatCode_tokenId;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getTokenId(int addr) {
        if (featOkTst && casFeat_tokenId == null)
      jcas.throwFeatMissing("tokenId", "de.unihd.dbs.uima.types.heideltime.Token");
    return ll_cas.ll_getIntValue(addr, casFeatCode_tokenId);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTokenId(int addr, int v) {
        if (featOkTst && casFeat_tokenId == null)
      jcas.throwFeatMissing("tokenId", "de.unihd.dbs.uima.types.heideltime.Token");
    ll_cas.ll_setIntValue(addr, casFeatCode_tokenId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_sentId;
  /** @generated */
  final int     casFeatCode_sentId;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getSentId(int addr) {
        if (featOkTst && casFeat_sentId == null)
      jcas.throwFeatMissing("sentId", "de.unihd.dbs.uima.types.heideltime.Token");
    return ll_cas.ll_getIntValue(addr, casFeatCode_sentId);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setSentId(int addr, int v) {
        if (featOkTst && casFeat_sentId == null)
      jcas.throwFeatMissing("sentId", "de.unihd.dbs.uima.types.heideltime.Token");
    ll_cas.ll_setIntValue(addr, casFeatCode_sentId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_pos;
  /** @generated */
  final int     casFeatCode_pos;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getPos(int addr) {
        if (featOkTst && casFeat_pos == null)
      jcas.throwFeatMissing("pos", "de.unihd.dbs.uima.types.heideltime.Token");
    return ll_cas.ll_getStringValue(addr, casFeatCode_pos);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPos(int addr, String v) {
        if (featOkTst && casFeat_pos == null)
      jcas.throwFeatMissing("pos", "de.unihd.dbs.uima.types.heideltime.Token");
    ll_cas.ll_setStringValue(addr, casFeatCode_pos, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Token_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_filename = jcas.getRequiredFeatureDE(casType, "filename", "uima.cas.String", featOkTst);
    casFeatCode_filename  = (null == casFeat_filename) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_filename).getCode();

 
    casFeat_tokenId = jcas.getRequiredFeatureDE(casType, "tokenId", "uima.cas.Integer", featOkTst);
    casFeatCode_tokenId  = (null == casFeat_tokenId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_tokenId).getCode();

 
    casFeat_sentId = jcas.getRequiredFeatureDE(casType, "sentId", "uima.cas.Integer", featOkTst);
    casFeatCode_sentId  = (null == casFeat_sentId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sentId).getCode();

 
    casFeat_pos = jcas.getRequiredFeatureDE(casType, "pos", "uima.cas.String", featOkTst);
    casFeatCode_pos  = (null == casFeat_pos) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_pos).getCode();

  }
}



    