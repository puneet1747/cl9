package URLReaderApp;

/**
* URLReaderApp/URLReaderHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from urlreader.idl
* Saturday, 7 May, 2022 4:00:30 PM IST
*/

public final class URLReaderHolder implements org.omg.CORBA.portable.Streamable
{
  public URLReaderApp.URLReader value = null;

  public URLReaderHolder ()
  {
  }

  public URLReaderHolder (URLReaderApp.URLReader initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = URLReaderApp.URLReaderHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    URLReaderApp.URLReaderHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return URLReaderApp.URLReaderHelper.type ();
  }

}
