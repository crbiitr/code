import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TLG {

	public static void main(String[] args) throws IOException {

		Reader_1 r =new Reader_1(System.in);
		Writer_1 w =new Writer_1(System.out);
		int n=r.readInt();  
		int player1=0, player2=0;
		int player1Score=0, player2Score=0;
		int winner=0,winnerLead=0;
		for(int i=0;i<n;i++) {
			int x = r.readInt();
			System.out.println(x);
		}
		
		 w.flush();

	}

}


class Reader_1
{
	private static final int  BUFSIZE   = 0x10000;
	private final byte[]      buffer    = new byte[BUFSIZE];
	private final ByteBuffer  bb        = ByteBuffer.wrap(buffer);
	private final FileChannel channel;

	int                       bufSize   = -1;                     // non empty buffer
	int                       bufOffset = 0;                      // non valid buffer

	private FileInputStream getFileInputStream(InputStream in)
	{
		try
		{
			if (in instanceof BufferedInputStream)
			{
				Field field = in.getClass().getSuperclass().getDeclaredField("in");
				field.setAccessible(true);
				return (FileInputStream) field.get(in);
			}
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
		return (FileInputStream) in;
	}

	Reader_1(InputStream in) throws IOException
	{
		this.channel = this.getFileInputStream(in).getChannel();
	}

	void fetchBuffer() throws IOException
	{
		bb.clear();
		bufSize = channel.read(bb);
		bufOffset = 0;
	}

	boolean isFinished()
	{
		return bufSize <= 0;
	}

	private int peek() throws IOException
	{
		if (bufOffset < bufSize)
			return buffer[bufOffset];
		fetchBuffer();
		if (bufSize > 0)
			return buffer[0];
		return -1;
	}

	private void skipSpace() throws IOException
	{
		int v = peek();
		while (v <= ' ' && v != -1)
		{
			bufOffset++;
			v = peek();
		}
	}

	void nextLine() throws IOException
	{
		int v = peek();
		while (v != -1 && v != '\n' && v != '\r')
		{
			bufOffset++;
			v = peek();
		}
		if (v == '\r')
		{
			bufOffset++;
			v = peek();
			if (v == '\n')
				bufOffset++;
		}
		else if (v == '\n')
		{
			bufOffset++;
			v = peek();
			if (v == '\r')
				bufOffset++;
		}
	}

	int readInt() throws IOException
	{
		skipSpace();
		int result = 0;
		int v = peek();
		while (v > ' ')
		{
			result = result * 10 + v - '0';
			bufOffset++;
			v = peek();
		}
		return result;
	}

}

class Writer_1
{
	private static final int       BUFSIZE = 0x10000;
	private final FileOutputStream fos;
	private final byte[]           buffer  = new byte[BUFSIZE];
	private int                    offset  = 0;

	private FileOutputStream getFileOutputStream(PrintStream out)
	{
		try
		{
			Field field = out.getClass().getSuperclass().getDeclaredField("out");
			field.setAccessible(true);
			OutputStream os = (OutputStream) field.get(out);
			if (os instanceof BufferedOutputStream)
			{
				BufferedOutputStream bos = (BufferedOutputStream) os;
				field = bos.getClass().getSuperclass().getDeclaredField("out");
				field.setAccessible(true);
				return (FileOutputStream) field.get(bos);
			}
			return (FileOutputStream) field.get(out);
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
		return null;
	}

	Writer_1(PrintStream out) throws IOException
	{
		fos = getFileOutputStream(out);
	}

	private static final int[]  boundaries = new int[]
			{
		9, 99, 999, 9999, 99999, 999999, 9999999,
		99999999, 999999999
			};
	private static final int[]  divs       = new int[]
			{
		1, 10, 100, 1000, 10000, 100000, 1000000,
		10000000, 100000000
			};
	private static final byte[] numbers    = "0123456789".getBytes();

	void writeln(int number) throws IOException
	{
		if (offset > BUFSIZE - 100)
			flush();
		int index;
		for (index = 0; index < boundaries.length; index++)
			if (number <= boundaries[index])
				break;
		for (; index >= 0; index--)
		{
			int mult = number / divs[index];
			buffer[offset++] = numbers[mult];
			number -= mult * divs[index];
		}
		buffer[offset++] = '\n';
	}

	void flush() throws IOException
	{
		if (offset > 0)
		{
			fos.write(buffer, 0, offset);
			offset = 0;
		}
	}
}
