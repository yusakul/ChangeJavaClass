import org.gjt.jclasslib.io.ClassFileWriter;
import org.gjt.jclasslib.structures.ClassFile;
import org.gjt.jclasslib.structures.Constant;
import org.gjt.jclasslib.structures.constants.ConstantStringInfo;
import org.gjt.jclasslib.structures.constants.ConstantUtf8Info;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;


public class main {
    public static void main(String[] args) throws Exception {
        String filePath = "D:\\test.class";//新建的需要進行操作的資料夾
        FileInputStream fis = new FileInputStream(filePath);

        DataInput di = new DataInputStream(fis);
        ClassFile cf = new ClassFile();
        cf.read(di);
        Constant[] infos = cf.getConstantPool();

        int count = infos.length;
        for(int i = 0; i < count; i++) {
            if(infos[i] != null) {
                System.out.print(i);
                System.out.print(" = ");
                System.out.print(infos[i].getVerbose());
                System.out.print(" = ");
//				System.out.println(infos[i].getVerbose() != "");
                System.out.println(infos[i].getVerbose() != "" ? infos[i].getConstantType() : "");
                if(i == 274) {
                    //解決cast錯誤
                    //ConstantStringInfo sInfo = (ConstantStringInfo) infos[i];
                    //int strIndex = sInfo.getStringIndex();
                    //ConstantUtf8Info uInfo = (ConstantUtf8Info)infos[strIndex];

                    ConstantUtf8Info uInfo = (ConstantUtf8Info)infos[i];
                    uInfo.setString("-----BEGIN CERTIFICATE-----\nMIIE7jCCAtagAwIBAgIIE9LQW6gcBZowDQYJKoZIhvcNAQELBQAwHTEbMBkGA1UE\nAxMSUG9sYXJQcm94eSBSb290IENBMB4XDTE3MTExOTA5NDIxMloXDTMwMTExOTA5\nNDIxMlowHTEbMBkGA1UEAxMSUG9sYXJQcm94eSBSb290IENBMIICIjANBgkqhkiG\n9w0BAQEFAAOCAg8AMIICCgKCAgEAtT6ZI8YC+b6eUfZvdJh7qn72J2FGjGTniIZl\nWVcLEW0CbRpaZIVc/WjWMkEc87l1GUK/3UV+M/Y9P/AK8tsIGdshuOkULsQIBAbG\nZHBsJHrYyttNQfonxfh+RR/J7fQljwUdBiI/jqTeadwaEaG7BRxsowFYGKf8CHfq\ncKU3WQce7wfx5y5/nQpbHHyaNbynI1HwsG1SjjhOZrEPv242GCMv7HPnkJDH8al4\naFgkAIC28CYGopaAvzTPhDt4ezlaywHutPwc2Y71cw9hjoo8tXCydrVe/aUgD8Jt\na1bfxR9XFhyT8omf8TA//oD5GOWOlnIA543c40MyUAFxkXjFBEWR58EvemIaD2kF\n67ApTpDJi+NC39FlxNpD5l8/n3UCarYf76PXB3yBIJYmPSLT6+qrN0zzg2dNPzsa\nCCjHJae2w0KruhAZgO0F58j6/+qRoyCFVlm4aTuBq7kZ5EySJFzK84KuR2YqY3fs\nuAQdq54jBS7F6u281IQN2a4+pXbNdaPYnJBht9hGGID41kGr09DNOURA4yNz8GHD\nu6AI4EZXqZyuyYhSMgL+wf0gIwijR+ESxbfJu4RPUvRijoq0mh+hdAhkV41hYj+J\nCfu0e8rXHlHOomaVdzQFyGmen+m+Xsc7APGGYRxHXodNCuO32BN+KCcQgEZU5N1g\n9j0Uz4ECAwEAAaMyMDAwDwYDVR0TAQH/BAUwAwEB/zAdBgNVHQ4EFgQUecgkrY6R\nPPNTnwpA7KGPN8RPlVYwDQYJKoZIhvcNAQELBQADggIBAJRuysjPTmbqSrDyoXRg\nKtm3UOIDoeeib/0PzUSXOM+hiKaOvHr79++UxtfYs0za4jlC9esLJ3ElXVdrx/B8\naj5ksmds0XmALf2SGC2EU4f0cYxC/TQR3oQm75Pg0AcFuaYCwphbGUteC5IMgJZ4\nlk+9hQB3QrFGbUoes/0B4LhSjz+YFbuAB8tCvtXED1yfoOrmm23+h2hXYjY8u657\ndC5dfmHBgqqJMfzlb+UK4+RSiGqjKcLhWj1rjxH3yptZumLvCIpj184wBSRHCglG\naH8CsD7iEJXXxuCeVo37uLHxB+LN5aVsnnfTRCAZolyneJtI+FU8bFG6moO1xNr8\nEolgACIsUN39292B+u2GP7y+jNIHuoAO1zFjNJDDUCpvltmr11EjjB8uHEmU3OuQ\nnz3hkaVbPBROcaGpRDySNPirasHiFjVKVvJUYMGMqC83iwe9s/TS+cpx87UFNn7J\nK1GMDMQU6qPV0IfcaLra1acn3V6zqza+oMzhoCGuqD4Cx75MQyM+7mUh5CfuQr6l\n0QA0h7UJ+RqkQCmVGCqgNQ3xeY06eR7nxzuBdqw4UbhdvGRaO/Ugfg/62UrE64R0\nn92v17/nARyuRRw7H7LKVovOx/u32l6qMjsemMl4X626AxGVis9Aq3lI4qI+WJvi\n8cLi/wOPE4XKNtA+4uo2q1np\n-----END CERTIFICATE-----\n");
                    //uInfo.setBytes("芝麻不开门!".getBytes());
                    infos[i]=uInfo;
                }
            }
        }
        cf.setConstantPool(infos);
        fis.close();
        File f = new File(filePath);
        ClassFileWriter.writeToFile(f, cf);


    }

}