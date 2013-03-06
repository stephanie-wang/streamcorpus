/**
 * generated by Scrooge 3.0.7-SNAPSHOT
 */
package streamcorpus

import com.twitter.scrooge.{ThriftException, ThriftStruct, ThriftStructCodec}
import org.apache.thrift.protocol._
import java.nio.ByteBuffer
import scala.collection.mutable
import scala.collection.{Map, Set}

/**
 * Description of a natural language used in text
 */
object Language extends ThriftStructCodec[Language] {
  val Struct = new TStruct("Language")
  val CodeField = new TField("code", TType.STRING, 1)
  val NameField = new TField("name", TType.STRING, 2)

  /**
   * Checks that all required fields are non-null.
   */
  def validate(_item: Language) {
  }

  def encode(_item: Language, _oproto: TProtocol) { _item.write(_oproto) }
  def decode(_iprot: TProtocol) = Immutable.decode(_iprot)

  def apply(_iprot: TProtocol): Language = decode(_iprot)

  def apply(
    code: String,
    name: Option[String] = None
  ): Language = new Immutable(
    code,
    name
  )

  def unapply(_item: Language): Option[Product2[String, Option[String]]] = Some(_item)

  object Immutable extends ThriftStructCodec[Language] {
    def encode(_item: Language, _oproto: TProtocol) { _item.write(_oproto) }
    def decode(_iprot: TProtocol) = {
      var code: String = null
      var _got_code = false
      var name: String = null
      var _got_name = false
      var _done = false
      _iprot.readStructBegin()
      while (!_done) {
        val _field = _iprot.readFieldBegin()
        if (_field.`type` == TType.STOP) {
          _done = true
        } else {
          _field.id match {
            case 1 => { /* code */
              _field.`type` match {
                case TType.STRING => {
                  code = {
                    _iprot.readString()
                  }
                  _got_code = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case 2 => { /* name */
              _field.`type` match {
                case TType.STRING => {
                  name = {
                    _iprot.readString()
                  }
                  _got_name = true
                }
                case _ => TProtocolUtil.skip(_iprot, _field.`type`)
              }
            }
            case _ => TProtocolUtil.skip(_iprot, _field.`type`)
          }
          _iprot.readFieldEnd()
        }
      }
      _iprot.readStructEnd()
      new Immutable(
        code,
        if (_got_name) Some(name) else None
      )
    }
  }

  /**
   * The default read-only implementation of Language.  You typically should not need to
   * directly reference this class; instead, use the Language.apply method to construct
   * new instances.
   */
  class Immutable(
    val code: String,
    val name: Option[String] = None
  ) extends Language

  /**
   * This Proxy trait allows you to extend the Language trait with additional state or
   * behavior and implement the read-only methods from Language using an underlying
   * instance.
   */
  trait Proxy extends Language {
    protected def _underlying_Language: Language
    def code: String = _underlying_Language.code
    def name: Option[String] = _underlying_Language.name
  }
}

trait Language extends ThriftStruct
  with Product2[String, Option[String]]
  with java.io.Serializable
{
  import Language._

  def code: String
  def name: Option[String]

  def _1 = code
  def _2 = name

  override def write(_oprot: TProtocol) {
    Language.validate(this)
    _oprot.writeStructBegin(Struct)
    if (true) {
      val code_item = code
      _oprot.writeFieldBegin(CodeField)
      _oprot.writeString(code_item)
      _oprot.writeFieldEnd()
    }
    if (name.isDefined) {
      val name_item = name.get
      _oprot.writeFieldBegin(NameField)
      _oprot.writeString(name_item)
      _oprot.writeFieldEnd()
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    code: String = this.code, 
    name: Option[String] = this.name
  ): Language = new Immutable(
    code, 
    name
  )

  override def canEqual(other: Any): Boolean = other.isInstanceOf[Language]

  override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)

  override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)

  override def toString: String = runtime.ScalaRunTime._toString(this)


  override def productArity: Int = 2

  override def productElement(n: Int): Any = n match {
    case 0 => code
    case 1 => name
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix: String = "Language"
}